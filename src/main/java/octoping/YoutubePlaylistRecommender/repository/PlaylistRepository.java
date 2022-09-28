package octoping.YoutubePlaylistRecommender.repository;

import javax.persistence.EntityManager;

import octoping.YoutubePlaylistRecommender.domain.VideoSong;
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

    public void save(VideoSong videoSong) {
        em.persist(videoSong);
    }

    public Video findOne(String videoId) {
        return em.find(Video.class, videoId);
    }
}
