package pairmatching.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static pairmatching.handler.ConstantsHandler.COURSE_LEVEL_MISSIONS_DELIMITER;
import static pairmatching.handler.ErrorHandler.INVALID_FORMAT;

public class CourseLevelMissions {

    private final List<String> values;

    private CourseLevelMissions(String inputValue) {
        this.values = validateFormat(inputValue);
    }

    public static CourseLevelMissions from(String inputValue) {
        return new CourseLevelMissions(inputValue);
    }

    private List<String> validateFormat(String inputValue) {
        String regex = "^[a-z|A-Z|ㄱ-ㅎ|가-힣ㅣ0-9]+,\\s[a-z|A-Z|ㄱ-ㅎ|가-힣ㅣ0-9]+,\\s[a-z|A-Z|ㄱ-ㅎ|가-힣ㅣ0-9]+$";

        if (!Pattern.matches(regex, inputValue)) {
            throw INVALID_FORMAT.getException();
        }

        List<String> values = Arrays.asList(inputValue.split(COURSE_LEVEL_MISSIONS_DELIMITER.getWord()));
        return values;
    }
}
