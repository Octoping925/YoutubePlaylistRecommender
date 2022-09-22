package octoping.YoutubePlaylistRecommender.common.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelperTest {

    @Test
    void parseKorean() {
        // given
        String txt1 = "Hello, World!";
        String txt2 = "안녕, 세상!";
        String txt3 = "그 때 ㄱ나니?";

        // when
        String result1 = Helper.parseKorean(txt1);
        String result2 = Helper.parseKorean(txt2);
        String result3 = Helper.parseKorean(txt3);

        // then
        assertEquals(" ", result1);
        assertEquals("안녕 세상", result2);
        assertEquals("그 때 ㄱ나니", result3);
    }
}