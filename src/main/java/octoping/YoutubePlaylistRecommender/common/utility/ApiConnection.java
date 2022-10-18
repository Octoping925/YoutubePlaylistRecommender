package octoping.YoutubePlaylistRecommender.common.utility;

import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;


public class ApiConnection {

    /**
     * GET으로 API 통신을 보내는 함수
     * @param apiUrl API 통신을 보낼 URI
     * @return API 통신 결과 JSONObject
     */
    public static JSONObject getJson(String apiUrl) {
        WebClient webClient = makeWebClient(apiUrl);

        ResponseEntity<HashMap> block = webClient.get()
                                                .retrieve()
                                                .onStatus(HttpStatus::is4xxClientError, response -> {
                                                    throw new IllegalStateException("WebClient Connection Failed, apiUrl = " + apiUrl);
                                                })
                                                .onStatus(HttpStatus::is5xxServerError, response -> {
                                                    throw new IllegalStateException("WebClient Server Error, apiUrl = " + apiUrl);
                                                })
                                                .toEntity(HashMap.class)
                                                .block();

        return new JSONObject(block.getBody());
    }

    private static WebClient makeWebClient(String apiUrl) {
        return WebClient.builder()
            .baseUrl(apiUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    }

}
