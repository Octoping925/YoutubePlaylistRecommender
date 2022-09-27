package octoping.YoutubePlaylistRecommender.common.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.domain.Keyword;

@Repository
@RequiredArgsConstructor
public class KeywordRepository {
    private final EntityManager em;

    public void save(Keyword keyword) {
        em.persist(keyword);
    }

    public Keyword findOne(Long keywordId) {
        return em.find(Keyword.class, keywordId);
    }
    
}
