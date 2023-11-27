package pairmatching.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static pairmatching.handler.ConstantsHandler.COURSE_LEVEL_MISSIONS_DELIMITER;
import static pairmatching.handler.ConstantsHandler.ZERO_INDEX;
import static pairmatching.handler.ErrorHandler.INVALID_COURSE;
import static pairmatching.handler.ErrorHandler.INVALID_FORMAT;

public class CourseLevelMissions {

    private final List<String> values;
    private final Course course;

    private CourseLevelMissions(String inputValue) {
        this.values = validateFormat(inputValue);
        this.course = validateCourse(values.get(ZERO_INDEX.getValue()));
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

    private Course validateCourse(String courseName) {
        try {
            Course course = Course.getCourse(courseName);
            return course;
        } catch (IllegalArgumentException e) {
            throw INVALID_COURSE.getException();
        }
    }
}
