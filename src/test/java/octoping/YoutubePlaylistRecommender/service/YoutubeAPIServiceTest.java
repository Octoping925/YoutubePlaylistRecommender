package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class YoutubeAPIServiceTest {
    @Autowired private YoutubeService youtubeAPIService;
//    private final YoutubeService youtubeAPIService
//        = new YoutubeAPIService();
//        = new YoutubeAPIService_Mocked();
    private final String videoId = "FAt0GAmpMFM";

    @Test
    void getYoutubeVideoOverview() throws IOException {
        System.out.println(youtubeAPIService.getYoutubeVideoOverview(videoId));
    }

    @Test
    void getYoutubeVideoComment() throws IOException {
        System.out.println(youtubeAPIService.getYoutubeVideoComment(videoId));
    }
}