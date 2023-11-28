package pairmatching.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.handler.ErrorHandler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CourseLevelMissionsTest {

    @DisplayName("입력값이 양식과 맞지 않다면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @ValueSource(strings = {"프론트엔드,레벨1,자동차경주", "프론트엔드,  @, !!", "프론트엔드, "})
    void createCourseLevelMissionsByInvalidFormat(String inputValue) {
        assertThatThrownBy(() -> CourseLevelMissions.from(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_FORMAT.getException().getMessage());
    }
}
