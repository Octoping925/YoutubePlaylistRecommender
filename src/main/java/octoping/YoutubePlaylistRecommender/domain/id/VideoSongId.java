package octoping.YoutubePlaylistRecommender.domain.id;

import lombok.Getter;
import lombok.Setter;
import octoping.YoutubePlaylistRecommender.common.config.ExceptionConstants;
import octoping.YoutubePlaylistRecommender.domain.Song;
import octoping.YoutubePlaylistRecommender.domain.Video;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class VideoSongId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "videoId")
    Video video;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "songId")
    Song song;

    protected VideoSongId() {
//        // throw new IllegalStateException(ExceptionConstants.NOARG_CONSTRUCTOR_EXCEPTION);
    }

    public VideoSongId(Video video, Song song) {
        this.video = video;
        this.song = song;
    }
}
