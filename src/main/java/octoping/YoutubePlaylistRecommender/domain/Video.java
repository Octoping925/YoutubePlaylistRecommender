package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;

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
}
