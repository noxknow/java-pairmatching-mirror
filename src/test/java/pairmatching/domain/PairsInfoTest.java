package pairmatching.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PairsInfoTest {

    private static Stream<Arguments> testHavePairs() { // List.of()가 자바 9버전 부터 가능해서 Arrays.asList() 사용
        return Stream.of(
                Arguments.of(PairsInfo.of(Arrays.asList("이브", "월터", "보노", "제키"), "백엔드", "레벨1", "자동차경주"),
                        "백엔드", "레벨1", "자동차경주", true),
                Arguments.of(PairsInfo.of(Arrays.asList("이브", "월터", "보노", "제키"), "프론트엔드", "레벨2", "장바구니"),
                        "프론트엔드", "레벨2", "결제", false)
        );
    }

    @DisplayName("매칭 정보가 있다면 true 를 없다면 false 를 반환한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @MethodSource("testHavePairs")
    void havePairsReturnTrueOrFalse(PairsInfo pairsInfo, String courseName, String levelName, String missionName, boolean expectedResult) {
        assertThat(pairsInfo.havePairs(courseName, levelName, missionName)).isEqualTo(expectedResult);
    }
}
