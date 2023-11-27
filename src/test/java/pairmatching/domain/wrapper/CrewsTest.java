package pairmatching.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CrewsTest {

    private static Stream<Arguments> testCreateCrews() throws IOException { // List.of()가 자바 9버전 부터 가능해서 Arrays.asList() 사용
        return Stream.of(
                Arguments.of(Crews.from("backend"), Arrays.asList(
                        "백호", "태웅", "치수", "태섭", "대만",
                        "준호", "대협", "덕규", "태산", "경태",
                        "수겸", "현준", "준섭", "한나", "소연",
                        "호열", "대남", "용팔", "구식", "달재"
                )),
                Arguments.of(Crews.from("frontend"), Arrays.asList(
                        "보노", "시저", "쉐리", "신디", "다비",
                        "덴버", "이브", "제시", "라라", "린다",
                        "리사", "니콜", "로드", "윌터", "제키"
                ))
        );
    }

    @DisplayName("과정에 따른 크루 리스트를 정상적으로 반환한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @MethodSource("testCreateCrews")
    void createCrews(Crews crews, List<String> expectedResult) {
        assertThat(crews.getCrews()).isEqualTo(expectedResult);
    }
}
