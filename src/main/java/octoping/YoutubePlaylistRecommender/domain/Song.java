package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long songId;

    @OneToMany(mappedBy = "videoSongId.song")
    Set<VideoSong> videoSong = new HashSet<>();

    @OneToMany(mappedBy = "songKeywordId.song")
    Set<SongKeyword> keywords = new HashSet<>();

    String title;
    String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
}
