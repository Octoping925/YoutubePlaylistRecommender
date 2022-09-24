package octoping.YoutubePlaylistRecommender.domain.id;

import lombok.Getter;
import lombok.Setter;
import octoping.YoutubePlaylistRecommender.common.config.ExceptionConstants;
import octoping.YoutubePlaylistRecommender.domain.Keyword;
import octoping.YoutubePlaylistRecommender.domain.Video;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class VideoKeywordId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "videoKeywords")
    Video video;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keywords")
    Keyword keyword;

    protected VideoKeywordId() {
        // throw new IllegalStateException(ExceptionConstants.NOARG_CONSTRUCTOR_EXCEPTION);
    }

    public VideoKeywordId(Video video, Keyword keyword) {
        this.video = video;
        this.keyword = keyword;
    }

}
