package octoping.YoutubePlaylistRecommender.common.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    private Helper() {
        throw new IllegalStateException("Utility Class");
    }
    
    public static String parseKorean(String text) {
        StringBuilder sb = new StringBuilder();

        Pattern p = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣 ]");
        Matcher m = p.matcher(text);

        while(m.find()) {
            sb.append(m.group());
        }

        return sb.toString();
    }
}
