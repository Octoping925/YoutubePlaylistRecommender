package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;
import octoping.YoutubePlaylistRecommender.common.config.ExceptionConstants;
import octoping.YoutubePlaylistRecommender.domain.id.VideoSongId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class VideoSong {
    @EmbeddedId
    private VideoSongId videoSongId;

    protected VideoSong() {
//        // throw new IllegalStateException(ExceptionConstants.NOARG_CONSTRUCTOR_EXCEPTION);
    }

    public VideoSong(Video video, Song song) {
        this.videoSongId = new VideoSongId(video, song);
    }

}
