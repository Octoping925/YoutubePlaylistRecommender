package octoping.YoutubePlaylistRecommender.common.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.domain.Video;

@Repository
@RequiredArgsConstructor
public class PlaylistRepository {
    private final EntityManager em;

    public void save(Video video) {
        em.persist(video);
    }

    public Video findOne(String videoId) {
        return em.find(Video.class, videoId);
    }
}
