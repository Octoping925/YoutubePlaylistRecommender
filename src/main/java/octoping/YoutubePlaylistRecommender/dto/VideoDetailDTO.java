package octoping.YoutubePlaylistRecommender.dto;

import java.util.List;
import lombok.Data;
import octoping.YoutubePlaylistRecommender.domain.Keyword;
import octoping.YoutubePlaylistRecommender.domain.Video;

@Data
public class VideoDetailDTO {
    String videoId;
    String title;
    List<SongDetailDTO> songs;
    List<String> keywords;
    String uploader;
    String description;

    public VideoDetailDTO(Video video) {
        this.videoId = video.getVideoId();
        this.title = video.getTitle();
        this.songs = video.getSongs().stream().map(SongDetailDTO::new).toList();
        this.keywords = video.getKeywords().stream().map(Keyword::getKeyword).toList();
        this.uploader = video.getUploader();
        this.description = video.getDescription();
    }

}
