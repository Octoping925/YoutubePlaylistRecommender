package octoping.YoutubePlaylistRecommender.vo;

import lombok.Data;

@Data
public class PlaylistVO {
    String title;
    String description;
    String channelTitle;

    public PlaylistVO(String title, String description, String channelTitle) {
        this.title = title;
        this.description = description;
        this.channelTitle = channelTitle;
    }
}
