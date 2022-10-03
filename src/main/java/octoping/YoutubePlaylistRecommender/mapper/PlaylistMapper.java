package octoping.YoutubePlaylistRecommender.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlaylistMapper {
    List<Map<String, String>> getPlaylists() throws Exception;
    List<Map<String, String>> searchPlaylistsBySong(HashMap<String, String> param) throws Exception;


}
