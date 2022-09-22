package octoping.YoutubePlaylistRecommender.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final YoutubeAPIService youtubeAPIService;

    public void crawl(String videoId) {

    }
}
