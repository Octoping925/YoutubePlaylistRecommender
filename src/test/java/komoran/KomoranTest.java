package komoran;

import java.util.List;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KomoranTest {
    /**
     * Komoran 공식 문서 : https://komorandocs.readthedocs.io/ko/latest/index.html
     */

    private final String playlistTitle
//        = "한강이나 갈까? 편하게 입고 나와, 시원한 밤공기와 함께 틀어놓기 좋은 노래 모음";
//        = "활력 충전!! 광란의 노동요 플레이리스트 | 신나는 집중력 향상 음악";
        = "[Playlist] 아, 이 노래들은 진짜 알려주기 아까운데ㅣOh, I really don't want to tell you these songs";
    private final Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
    private final KomoranResult analyzeResultList = komoran.analyze(playlistTitle);

    @Test
    void Komoran_getPlainText() {
        System.out.println(analyzeResultList.getPlainText());
    }

    @Test
    void Komoran_getTokenList() {
        List<Token> tokenList = analyzeResultList.getTokenList();
        System.out.println("tokenList.size() = " + tokenList.size());
        tokenList.forEach(token -> System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos()));
    }

    @Test
    void Komoran_getNoun() {
        List<String> nouns = analyzeResultList.getNouns();
        System.out.println("nouns.size() = " + nouns.size());
        nouns.forEach(System.out::println);
    }

    @Test
    @DisplayName("형용사 얻기")
    void Komoran_getVA() {
        List<String> va = analyzeResultList.getMorphesByTags("VA");
        System.out.println("va.size() = " + va.size());
        va.forEach(System.out::println);
    }

    @Test
    @DisplayName("어근 얻기")
    void Komoran_getXR() {
        List<String> xr = analyzeResultList.getMorphesByTags("XR");
        System.out.println("xr.size() = " + xr.size());
        xr.forEach(System.out::println);
    }
}
