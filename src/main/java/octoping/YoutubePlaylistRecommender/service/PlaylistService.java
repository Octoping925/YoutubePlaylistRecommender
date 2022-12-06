package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.common.config.KeywordConfig;
import octoping.YoutubePlaylistRecommender.common.utility.Helper;
import octoping.YoutubePlaylistRecommender.common.utility.WordParser;
import octoping.YoutubePlaylistRecommender.domain.Keyword;
import octoping.YoutubePlaylistRecommender.domain.Song;
import octoping.YoutubePlaylistRecommender.domain.SongKeyword;
import octoping.YoutubePlaylistRecommender.domain.Video;
import octoping.YoutubePlaylistRecommender.domain.VideoKeyword;
import octoping.YoutubePlaylistRecommender.domain.VideoSong;
import octoping.YoutubePlaylistRecommender.repository.KeywordRepository;
import octoping.YoutubePlaylistRecommender.repository.PlaylistRepository;
import octoping.YoutubePlaylistRecommender.repository.SongRepository;
import octoping.YoutubePlaylistRecommender.vo.CommentVO;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final YoutubeService youtubeService;
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final KeywordRepository keywordRepository;
    private final KeywordConfig keywordConfig;

    @Transactional
    public void crawl(String videoId) throws IOException {
        if(isAlreadyCrawledPlaylist(videoId)) return;

        // 동영상 크롤링
        PlaylistVO playlistVO = youtubeService.getYoutubeVideoOverview(videoId);
        List<CommentVO> commentVO = youtubeService.getYoutubeVideoComment(videoId);

        // 동영상 정보 DB에 저장
        Video video = new Video(playlistVO, videoId);
        playlistRepository.save(video);

        // 노래 정보 DB에 저장
        Set<Song> songs = parseSongs(video.getDescription(), commentVO);
        songs.forEach(songRepository::save);

        // 키워드 정보 DB에 저장
        Set<Keyword> keywords = parseKeywords(playlistVO);
        keywords.forEach(keywordRepository::save);

        // 노래 연관관계 저장
        songs.forEach(song -> {
            VideoSong videoSong = new VideoSong(video, song);
            playlistRepository.save(videoSong);
        });

        // 키워드 연관관계 저장
        keywords.forEach(keyword -> {
            VideoKeyword videoKeyword = new VideoKeyword(video, keyword);
            keywordRepository.save(videoKeyword);

            songs.forEach(song -> {
                SongKeyword songKeyword = new SongKeyword(song, keyword);
                keywordRepository.save(songKeyword);
            });
        });
    }

    private boolean isAlreadyCrawledPlaylist(String videoId) {
        return playlistRepository.findOne(videoId).isPresent();
    }

    private Set<Song> parseSongs(String videoDescription, List<CommentVO> commentVOs) {
        Set<Song> songs = parseSongsFromVideoDescription(videoDescription);
        List<Set<Song>> songListFromComments = parseSongsFromComments(commentVOs);

        for(Set<Song> songList : songListFromComments) {
            if(songList.size() > songs.size()) {
                songs = songList;
            }
        }

        return songs;
    }

    private Set<Song> parseSongsFromVideoDescription(String videoDescription) {
        return getSongsFromText(videoDescription);
    }

    private List<Set<Song>> parseSongsFromComments(List<CommentVO> commentVOs) {
        return commentVOs.stream()
                .map(vo -> getSongsFromText(vo.getContent()))
                .toList();
    }

    private Set<Song> getSongsFromText(String text) {
        Set<Song> songList = new HashSet<>();
        String[] textLine = text.split("\n");

        String beforeTimeLine = null;
        for(String line : textLine) {
            String[] splitArr = line.split("\\d\\d(:\\d\\d)+");
            if(splitArr.length <= 1) continue;

            String songInfo = splitArr[splitArr.length - 1];
            String timeline = line.substring(0, line.indexOf(songInfo));

            if(beforeTimeLine != null && !beforeTimeLine.equals(timeline)) {
                String[] songInfoSplitArr = songInfo.split("-", 2);
                if(songInfoSplitArr.length == 1) {
                    songList.add(Song.create(songInfoSplitArr[0].trim()));
                }
                else {
                    songList.add(Song.create(songInfoSplitArr[1].trim(), songInfoSplitArr[0].trim()));
                }
            }

            beforeTimeLine = timeline;
        }

        return songList;
    }

    private Set<Keyword> parseKeywords(PlaylistVO vo) {
        Set<String> keywords = new HashSet<>();
        keywords.addAll(parseKeywordsFromVideoTitle(vo.getTitle()));
        keywords.addAll(parseKeywordsFromVideoTags(vo.getTags()));

        return keywords.stream()
                .filter(keyword -> !keywordConfig.isContainExcludeList(keyword))
                .map(Keyword::new)
                .collect(Collectors.toSet());
    }

    private Set<String> parseKeywordsFromVideoTitle(String videoTitle) {
        String koreanTitle = Helper.parseKorean(videoTitle);
        List<String> nouns = WordParser.getNoun(koreanTitle);
        return Set.copyOf(nouns);
    }

    private Set<String> parseKeywordsFromVideoTags(List<String> tags) {
        return Set.copyOf(tags);
    }

    public Video getPlaylistByVideoId(String videoId) {
        return playlistRepository.findOne(videoId)
            .orElseThrow(() -> new NoSuchElementException("해당 플레이리스트가 존재하지 않습니다."));
    }
}
