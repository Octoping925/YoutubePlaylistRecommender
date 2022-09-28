package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;
import octoping.YoutubePlaylistRecommender.common.config.ExceptionConstants;
import octoping.YoutubePlaylistRecommender.domain.id.VideoKeywordId;

import javax.persistence.*;

@Entity
@Getter
public class VideoKeyword {
    @EmbeddedId
    private VideoKeywordId videoKeywordId;

    protected VideoKeyword() {
//        // throw new IllegalStateException(ExceptionConstants.NOARG_CONSTRUCTOR_EXCEPTION);
    }

     public VideoKeyword(Video video, Keyword keyword) {
         this.videoKeywordId = new VideoKeywordId(video, keyword);
         video.getVideoKeywords().add(this);
         keyword.getVideoKeywords().add(this);
     }
}
