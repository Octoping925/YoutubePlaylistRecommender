package octoping.YoutubePlaylistRecommender.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.anyLong;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.doReturn;
import static org.mockito.BDDMockito.doThrow;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PlaylistServiceTest {
    @Autowired PlaylistService playlistService;
    @MockBean YoutubeService youtubeService;
    YoutubeAPIService_Mocked youtubeAPIService_mocked = new YoutubeAPIService_Mocked();

    String videoId = "b_8A6ehYQYo";

    @Test
    void crawl() throws IOException {
        doReturn(youtubeAPIService_mocked.getYoutubeVideoComment(videoId)).when(youtubeService).getYoutubeVideoComment(anyString());
        doReturn(youtubeAPIService_mocked.getYoutubeVideoOverview(videoId)).when(youtubeService).getYoutubeVideoOverview(anyString());

        playlistService.crawl(videoId);
        System.out.println(1);

    }
}