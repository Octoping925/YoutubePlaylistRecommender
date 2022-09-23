package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import java.util.List;
import octoping.YoutubePlaylistRecommender.vo.CommentVO;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class YoutubeCrawlingService implements YoutubeService {
    public PlaylistVO getYoutubeVideoOverview(String videoId) throws IOException {
        return null;
    }

    public List<CommentVO> getYoutubeVideoComment(String videoId) throws IOException {
        return null;
    }
}
