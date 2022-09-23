package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;
import octoping.YoutubePlaylistRecommender.common.utility.Helper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final YoutubeService youtubeService;

    public void crawl(String videoId) throws IOException {
        PlaylistVO playlistVO = youtubeService.getYoutubeVideoOverview(videoId);

        String koreanTitle = Helper.parseKorean(playlistVO.getTitle());
        System.out.println(koreanTitle);
    }
}
