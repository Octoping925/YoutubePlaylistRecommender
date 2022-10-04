package octoping.YoutubePlaylistRecommender.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.doReturn;

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
    }

    @Test
    void getSongFromText() {
        String text = "Hello Autumn \uD83C\uDF42 가을이라는 장르 | 너의 일상 속, 작은 행복을 위해 [ \uD835\uDC91\uD835\uDC8D\uD835\uDC82\uD835\uDC9A\uD835\uDC8D\uD835\uDC8A\uD835\uDC94\uD835\uDC95 _ \uD835\uDC74\uD835\uDC86\uD835\uDC8A\uD835\uDC8A ????? ??????]\n" +
        "\n" +
        "00:00 View - Ethan Dufault\n" +
        "03:27 Nirvana - Zach Sorgen\n" +
        "06:17 Casualties - Ethan Dufault\n" +
        "09:58 California - Ethan Dufault\n" +
        "13:18 8Home - Zach Sorgen\n" +
        "16:18 Kryptonite - Ethan Dufault\n" +
        "19:27 Right next to You - Evening Traveler\n" +
        "23:32 When I Know - Ethan Dufault\n" +
        "26:36 Bluerock - Cayson Renshaw\n" +
        "30:21\n" +
        "01:12:48 OKAY - Ethan Dufault\n" +
        "\n" +
        "\uD83D\uDC9F 이 음악이 당신을 행복하게 했다면 더 많은 사람들이 함께 들을 수 있도록 소셜 페이지(Facebook, Reddit, Twitter 등)에 이 믹스를 좋아요, 구독 및 공유하십시오!\n" +
        "저희는 유튜브 음악 개발 회사입니다.\n" +
        "실력파 아티스트들의 협력을 기다립니다\n" +
        "? ? 모든 권리는 해당 소유자, 콘텐츠에 있습니다\n" +
        "\n" +
        "? 시청해주셔서 감사합니다!..댓글 잘 읽었습니다..저희가 공유하는 음악으로 여러분의 하루가 더 아름다워지기를 바랍니다!";

        String[] textLine = text.split("\n");

        for(String line : textLine) {
            String[] splitArr = line.split("\\d\\d(:\\d\\d)+");
            if(splitArr.length > 1) {
                String songInfo = splitArr[splitArr.length - 1];
                String timeline = line.substring(0, line.indexOf(songInfo));
                System.out.printf("%s,%s\n", timeline, songInfo.trim());
            }
        }
    }
}