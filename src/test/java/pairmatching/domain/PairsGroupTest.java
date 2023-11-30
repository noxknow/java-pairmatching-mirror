package pairmatching.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PairsGroupTest {

    private static Stream<Arguments> testHavePairs() {
        return Stream.of(
                Arguments.of(PairsGroup.create(), "백엔드", "레벨1", "자동차경주", false),
                Arguments.of(PairsGroup.create(), "프론트엔드", "레벨2", "결제", true)
        );
    }

    @DisplayName("매칭 정보가 있다면 true 를 없다면 false 를 반환한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @MethodSource("testHavePairs")
    void havePairsReturnTrueOrFalse(PairsGroup pairsGroup, String courseName, String levelName, String missionName, boolean expectedResult) {
        PairsInfo pairsInfo = PairsInfo.of(Arrays.asList("이브", "월터", "보노", "제키"), "프론트엔드", "레벨2", "결제");
        pairsGroup.addPairs(pairsInfo);

        assertThat(pairsGroup.havePairs(courseName, levelName, missionName)).isEqualTo(expectedResult);
    }
}
