package octoping.YoutubePlaylistRecommender.domain.id;

import lombok.Getter;
import lombok.Setter;
import octoping.YoutubePlaylistRecommender.common.config.ExceptionConstants;
import octoping.YoutubePlaylistRecommender.domain.Keyword;
import octoping.YoutubePlaylistRecommender.domain.Song;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class SongKeywordId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "songId")
    Song song;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keywordId")
    Keyword keyword;

    protected SongKeywordId() {
        // throw new IllegalStateException(ExceptionConstants.NOARG_CONSTRUCTOR_EXCEPTION);
    }

    public SongKeywordId(Song song, Keyword keyword) {
        this.song = song;
        this.keyword = keyword;
    }
}
