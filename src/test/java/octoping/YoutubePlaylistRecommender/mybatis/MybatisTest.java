package octoping.YoutubePlaylistRecommender.mybatis;

import octoping.YoutubePlaylistRecommender.mapper.PlaylistMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisTest {
    @Autowired PlaylistMapper playlistMapper;

    @Test
    void executeMybatis() throws Exception {
        System.out.println(playlistMapper.getPlaylists());
    }

}
