package octoping.YoutubePlaylistRecommender.common.utility;

import java.util.List;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;

public class WordParser {
    private static final Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

    /**
     * 명사 얻기
     */
    public static List<String> getNoun(String text) {
        return komoran.analyze(text).getNouns();
    }

    /**
     * 형용사 얻기
     */
    public static List<String> getVA(String text) {
        return komoran.analyze(text).getMorphesByTags("VA");
    }

    /**
     * 어근 얻기
     */
    public static List<String> getXR(String text) {
        return komoran.analyze(text).getMorphesByTags("XR");
    }
}
