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
        JSONObject snippet = (JSONObject) json.query("/items/0/snippet");

        return parsePlaylistVOFromSnippet(snippet);
    }

    private PlaylistVO parsePlaylistVOFromSnippet(JSONObject snippet) {
        String title = snippet.getString("title");
        String description = snippet.getString("description");
        String channelTitle = snippet.getString("channelTitle");
        List<String> tags = new ArrayList<>();

        if(snippet.has("tags")) {
            snippet.getJSONArray("tags").forEach(tag -> tags.add((String) tag));
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

        JSONObject json = ApiConnection.getJson(apiUrl);
        JSONArray items = json.getJSONArray("items");

        return parseCommentVOsFromItems(items);
    }

    private List<CommentVO> parseCommentVOsFromItems(JSONArray items) {
        List<CommentVO> vo = new ArrayList<>();

        items.forEach(item -> {
            JSONObject snippet = (JSONObject) ((JSONObject) item).query("/snippet/topLevelComment/snippet");

            // ??????????????? ?????? ????????? ????????????
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
