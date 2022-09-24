package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;
import octoping.YoutubePlaylistRecommender.common.config.ExceptionConstants;
import octoping.YoutubePlaylistRecommender.domain.id.SongKeywordId;

import javax.persistence.*;

@Entity
@Getter
public class SongKeyword {
    @EmbeddedId
    private SongKeywordId songKeywordId;

    protected SongKeyword() {
//        // throw new IllegalStateException(ExceptionConstants.NOARG_CONSTRUCTOR_EXCEPTION);
    }

    public SongKeyword(Song song, Keyword keyword) {
        this.songKeywordId = new SongKeywordId(song, keyword);
    }

}
