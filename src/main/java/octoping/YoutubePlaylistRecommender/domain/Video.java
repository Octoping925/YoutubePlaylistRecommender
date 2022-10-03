package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;
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
    String description;

    protected Video(){}

    public Video(PlaylistVO vo, String videoId) {
        this.videoId = videoId;
        this.title = vo.getTitle();
        this.uploader = vo.getChannelTitle();
        this.description = vo.getDescription();
    }
}
