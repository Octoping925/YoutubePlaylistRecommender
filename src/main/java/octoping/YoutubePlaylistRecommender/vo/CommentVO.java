package octoping.YoutubePlaylistRecommender.vo;

import lombok.Data;

@Data
public class CommentVO {
    String writer;
    String content;

    public CommentVO(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }
}
