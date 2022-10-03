package octoping.YoutubePlaylistRecommender.mybatis;

import octoping.YoutubePlaylistRecommender.mapper.PlaylistMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisTest {
    @Autowired PlaylistMapper playlistMapper;

    @Test
    void executeMybatis() throws Exception {
        List<Map<String, String>> playlists = playlistMapper.getPlaylists();
        System.out.println(playlists);
    }

    @Test
    void searchPlaylistsBySongTest() throws Exception {
        HashMap<String, String> param = new HashMap<>();
        param.put("P_SONGID", "1");
        List<Map<String, String>> playlists = playlistMapper.searchPlaylistsBySong(param);
        System.out.println(playlists.toString());
    }



}
