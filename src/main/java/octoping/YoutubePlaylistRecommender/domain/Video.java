package octoping.YoutubePlaylistRecommender.domain;

import java.util.List;
import javax.persistence.Column;
import lombok.Getter;
import octoping.YoutubePlaylistRecommender.domain.id.VideoKeywordId;
import octoping.YoutubePlaylistRecommender.domain.id.VideoSongId;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Video {
    @Id
    String videoId;

    @OneToMany(mappedBy = "videoSongId.video")
    Set<VideoSong> videoSongs = new HashSet<>();

    @OneToMany(mappedBy = "videoKeywordId.video")
    Set<VideoKeyword> videoKeywords = new HashSet<>();

    String title;
    String uploader;

    @Column(columnDefinition = "TEXT")
    String description;

    protected Video(){}

    public Video(PlaylistVO vo, String videoId) {
        this.videoId = videoId;
        this.title = vo.getTitle();
        this.uploader = vo.getChannelTitle();
        this.description = vo.getDescription();
    }

    public List<Song> getSongs() {
        return videoSongs.stream()
            .map(VideoSong::getVideoSongId)
            .map(VideoSongId::getSong)
            .toList();
    }

    public List<Keyword> getKeywords() {
        return videoKeywords.stream()
            .map(VideoKeyword::getVideoKeywordId)
            .map(VideoKeywordId::getKeyword)
            .toList();
    }
}
