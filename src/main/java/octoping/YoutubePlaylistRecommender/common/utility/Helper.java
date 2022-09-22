package octoping.YoutubePlaylistRecommender.common.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static String parseKorean(String text) {
        StringBuffer sb = new StringBuffer();

        Pattern p = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣 ]");
        Matcher m = p.matcher(text);

        while(m.find()) {
            sb.append(m.group());
        }

        return sb.toString();
    }
}
