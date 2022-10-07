package octoping.YoutubePlaylistRecommender.common.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeywordConfigTest {
    @Autowired KeywordConfig keywordConfig;

    @Test
    void readTextFile() {
        String path = "./src/main/java/octoping/YoutubePlaylistRecommender/common/config/KeywordExcludeList.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String text;
            while((text = br.readLine()) != null) {
                System.out.println(text);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fail("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}