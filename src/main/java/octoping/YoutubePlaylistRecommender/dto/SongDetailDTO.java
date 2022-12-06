package octoping.YoutubePlaylistRecommender.dto;

import java.util.List;
import lombok.Data;
import octoping.YoutubePlaylistRecommender.domain.Keyword;
import octoping.YoutubePlaylistRecommender.domain.Song;

@Data
public class SongDetailDTO {
    Long songId;
    String title;
    String artist;
    List<String> keywords;

    public SongDetailDTO(Song song) {
        this.songId = song.getSongId();
        this.title = song.getTitle();
        this.artist = song.getArtist();
        this.keywords = song.getKeywords()
            .stream()
            .map(Keyword::getKeyword)
            .toList();
    }
}
