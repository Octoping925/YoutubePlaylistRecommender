package octoping.YoutubePlaylistRecommender.controller;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.common.utility.ResponseObject;
import octoping.YoutubePlaylistRecommender.domain.Video;
import octoping.YoutubePlaylistRecommender.dto.VideoDetailDTO;
import octoping.YoutubePlaylistRecommender.repository.PlaylistRepository;
import octoping.YoutubePlaylistRecommender.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;

    @PostMapping("/playlist/{videoId}/crawl")
    public ResponseEntity<Map<String, Object>> crawl(@PathVariable(name = "videoId") String videoId) {
        try {
            playlistService.crawl(videoId);
            return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(ResponseObject.create(videoId, "크롤링 성공"));
        }
        catch (IOException e) {
            return new ResponseEntity<>(ResponseObject.create(null, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/playlist/{videoId}/info")
    public ResponseEntity<Map<String, Object>> getPlaylistInfo(@PathVariable(name = "videoId") String videoId) {
        try {
            Video playlist = playlistService.getPlaylistByVideoId(videoId);

            Map<String, Object> playlistInfo = Map.of(
                "videoDetail", new VideoDetailDTO(playlist)
            );

            return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(ResponseObject.create(playlistInfo, "플레이리스트 정보 조회 성공"));
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(ResponseObject.create(null, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/playlist/{videoId}/simillar")
    public void getSimillarSongsByPlaylist(@PathVariable(name = "videoId") String videoId) {

    }
}
