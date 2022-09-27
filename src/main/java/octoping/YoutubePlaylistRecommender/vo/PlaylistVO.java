package octoping.YoutubePlaylistRecommender.vo;

import java.util.List;

import lombok.Data;

@Data
public class PlaylistVO {
    String title;
    String description;
    String channelTitle;
    List<String> tags;

    public PlaylistVO(String title, String description, String channelTitle, List<String> tags) {
        this.title = title;
        this.description = description;
        this.channelTitle = channelTitle;
        this.tags = tags;
    }
}
