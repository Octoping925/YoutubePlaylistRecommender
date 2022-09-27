package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import octoping.YoutubePlaylistRecommender.vo.CommentVO;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;
import octoping.YoutubePlaylistRecommender.common.utility.ApiConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class YoutubeAPIService implements YoutubeService {
    @Value("${youtube.api.key}")
    String apiKey;

    public PlaylistVO getYoutubeVideoOverview(String videoId) throws IOException {
        String apiUrl = "https://www.googleapis.com/youtube/v3/videos"
            + "?key=" + apiKey
            + "&part=snippet"
            + "&id=" + videoId;

        JSONObject json = ApiConnection.getJson(apiUrl);
        JSONObject snippet = (JSONObject)((JSONObject)json.getJSONArray("items").get(0)).get("snippet");

        String title = snippet.getString("title");
        String description = snippet.getString("description");
        String channelTitle = snippet.getString("channelTitle");
        List<String> tags = new ArrayList<String>();

        try {
            snippet.getJSONArray("tags").forEach(tag -> tags.add((String) tag));
        }
        catch(Exception e) {
            System.out.println("tag가 존재하지 않는 video");
        }

        return new PlaylistVO(title, description, channelTitle, tags);
    }

    public List<CommentVO> getYoutubeVideoComment(String videoId) throws IOException {
        final String maxResults = "100";

        String apiUrl = "https://www.googleapis.com/youtube/v3/commentThreads"
            + "?key=" + apiKey
            + "&part=snippet"
            + "&videoId=" + videoId
            + "&maxResults=" + maxResults;

        List<CommentVO> vo = new ArrayList<>();
        JSONObject json = ApiConnection.getJson(apiUrl);
        JSONArray items = (JSONArray) json.get("items");
        items.forEach(item -> {
            JSONObject topLevelComment = (JSONObject)((JSONObject)((JSONObject)item).get("snippet")).get("topLevelComment");
            JSONObject snippet = (JSONObject) topLevelComment.get("snippet");

            // 타임라인이 없는 댓글은 무시한다
            String textDisplay = snippet.getString("textDisplay");
            if(textDisplay.contains("<a href=\"https://www.youtube.com/watch?")) {
                String writer = snippet.getString("authorDisplayName");
                String content = snippet.getString("textOriginal");
                vo.add(new CommentVO(writer, content));
            }
        });

        return vo;
    }

}
