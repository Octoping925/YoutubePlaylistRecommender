package octoping.YoutubePlaylistRecommender.common.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;


public class ApiConnection {

    /**
     * GET으로 API 통신을 보내는 함수
     * @param apiUrl API 통신을 보낼 URI
     * @return API 통신 결과 JSONObject
     */
    public static JSONObject getJson(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while((line = br.readLine()) != null) {
            sb.append(line);
        }

        return new JSONObject(sb.toString());
    }

}
