package octoping.YoutubePlaylistRecommender.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class KeywordConfig {
    @Value("${file.keyword-exclude-list.path}")
    String keywordExcludeListPath;
    private final Set<String> keywordExcludeList = new HashSet<>();

    @PostConstruct
    private void getKeywordExcludeListFromList() {
        try (BufferedReader br = new BufferedReader(new FileReader(keywordExcludeListPath))){
            String keyword;
            while((keyword = br.readLine()) != null) {
                keywordExcludeList.add(keyword);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isContainExcludeList(String keyword) {
        return this.keywordExcludeList.contains(keyword);
    }
}
