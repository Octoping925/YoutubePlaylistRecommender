package octoping.YoutubePlaylistRecommender.repository;

import javax.persistence.EntityManager;

import octoping.YoutubePlaylistRecommender.domain.SongKeyword;
import octoping.YoutubePlaylistRecommender.domain.VideoKeyword;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.domain.Keyword;

@Repository
@RequiredArgsConstructor
public class KeywordRepository {
    private final EntityManager em;

    public void save(Keyword keyword) {
        if(findOne(keyword.getKeyword()) == null)
            em.persist(keyword);
    }

    public void save(VideoKeyword videoKeyword) {
        em.persist(videoKeyword);
    }

    public void save(SongKeyword songKeyword) {
        em.persist(songKeyword);
    }

    public Keyword findOne(String keyword) {
        return em.find(Keyword.class, keyword);
    }
    
}
