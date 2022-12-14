package octoping.YoutubePlaylistRecommender.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.domain.Song;

@Repository
@RequiredArgsConstructor
public class SongRepository {
    private final EntityManager em;

    public void save(Song song) {
        em.persist(song);
    }

    public Song findOne(Long songId) {
        return em.find(Song.class, songId);
    }

    public boolean chkExist(String title, String artist) {
        return !em.createQuery("SELECT s FROM Song s WHERE s.title = :title AND s.artist = :artist", Song.class)
                .setParameter("title", title)
                .setParameter("artist", artist)
                .getResultList()
                .isEmpty();
    }
}
