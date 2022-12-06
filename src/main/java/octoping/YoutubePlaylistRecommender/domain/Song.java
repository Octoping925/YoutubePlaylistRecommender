package octoping.YoutubePlaylistRecommender.domain;

import java.util.List;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import octoping.YoutubePlaylistRecommender.domain.id.SongKeywordId;

@Entity
@Getter
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long songId;

    @OneToMany(mappedBy = "videoSongId.song")
    Set<VideoSong> videoSong = new HashSet<>();

    @OneToMany(mappedBy = "songKeywordId.song")
    Set<SongKeyword> songKeywords = new HashSet<>();

    String title;
    String artist;

    protected Song() {}

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public static Song create(String title) {
        return new Song(title, "unknown");
    }

    public static Song create(String title, String artist) {
        return new Song(title, artist);
    }

    /**
     * 가수와 노래 제목이 거꾸로 들어갔을 경우 스위칭
     */
    public void switchTitleAndArtist() {
        String tmp = title;
        title = artist;
        artist = tmp;
    }

    public List<Keyword> getKeywords() {
        return songKeywords.stream()
            .map(SongKeyword::getSongKeywordId)
            .map(SongKeywordId::getKeyword)
            .toList();
    }
}
