package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import octoping.YoutubePlaylistRecommender.vo.CommentVO;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;

public interface YoutubeService {
    private String getYoutubeVideoUrl(String videoId) {
        final String youtubeVideoUrl = "https://www.youtube.com/watch?v=";
        return youtubeVideoUrl + videoId;
    }

    PlaylistVO getYoutubeVideoOverview (String videoId) throws IOException;
    List<CommentVO> getYoutubeVideoComment(String videoId) throws IOException;
}