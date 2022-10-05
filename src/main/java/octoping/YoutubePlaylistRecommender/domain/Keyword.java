package octoping.YoutubePlaylistRecommender.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Keyword {
    @Id
    String keyword;

    @OneToMany(mappedBy = "videoKeywordId.keyword")
    Set<VideoKeyword> videoKeywords = new HashSet<>();

    @OneToMany(mappedBy = "songKeywordId.keyword")
    Set<SongKeyword> songKeywords = new HashSet<>();

    protected Keyword() {}

    public Keyword(String keyword) {
        this.keyword = keyword;
    }
}
