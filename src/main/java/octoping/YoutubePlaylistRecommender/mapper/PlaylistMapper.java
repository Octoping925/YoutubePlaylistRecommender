package octoping.YoutubePlaylistRecommender.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.mappers.LicenseMapper.LicenseTranslator;

@Mapper
@Repository
public interface PlaylistMapper {
    public List<Map<String, String>> getPlaylists() throws Exception;


}
