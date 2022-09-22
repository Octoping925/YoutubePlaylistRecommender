package octoping.YoutubePlaylistRecommender.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.common.utility.ResponseObject;
import octoping.YoutubePlaylistRecommender.service.PlaylistService;

@RequiredArgsConstructor
@RestController
public class PlaylistController {
    private final PlaylistService playlistService;
    
    @PostMapping("/playlist/{videoId}/crawl")
    public ResponseEntity<Map<String, Object>> crawl(@PathVariable(name = "videoId") String videoId) {
        playlistService.crawl(videoId);

        return ResponseEntity.ok()
            .body(ResponseObject.create(null, "크롤링 성공"));
    }

    @GetMapping("/playlist/{videoId}/info")
    public void getSongsByPlaylist(@PathVariable(name = "videoId") String videoId) {

    }

    @GetMapping("/playlist/{videoId}/simillar")
    public void getSimillarSongsByPlaylist(@PathVariable(name = "videoId") String videoId) {

    }
}
