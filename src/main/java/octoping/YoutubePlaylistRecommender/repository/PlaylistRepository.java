package octoping.YoutubePlaylistRecommender.repository;

import java.util.Optional;
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

    public Optional<Video> findOne(String videoId) {
        return Optional.ofNullable(em.find(Video.class, videoId));
    }
}
