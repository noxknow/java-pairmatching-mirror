package pairmatching.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static pairmatching.handler.ConstantsHandler.*;
import static pairmatching.handler.ErrorHandler.*;

public class CourseLevelMissions {

    private final List<String> values;
    private final String course;
    private final String level;
    private final String mission;

    private CourseLevelMissions(String inputValue) {
        this.values = validateFormat(inputValue);
        this.course = values.get(ZERO_INDEX.getValue());
        this.level = values.get(FIRST_INDEX.getValue());
        this.mission = values.get(SECOND_INDEX.getValue());
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

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
