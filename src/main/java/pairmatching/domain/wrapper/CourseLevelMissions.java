package pairmatching.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static pairmatching.handler.ConstantsHandler.*;
import static pairmatching.handler.ErrorHandler.*;

public class CourseLevelMissions {

    private final List<String> values;
    private final Course course;
    private final LevelMissions levelMissions;

    private CourseLevelMissions(String inputValue) {
        this.values = validateFormat(inputValue);
        this.course = validateCourse(values.get(ZERO_INDEX.getValue()));
        this.levelMissions = validateLevelMissions(values.get(FIRST_INDEX.getValue()), values.get(SECOND_INDEX.getValue()));
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

    private LevelMissions validateLevelMissions(String levelName, String missionName) {
        try {
            LevelMissions levelMissions = LevelMissions.getLevelMissions(levelName, missionName);
            return levelMissions;
        } catch (IllegalArgumentException e) {
            throw INVALID_LEVEL_MISSIONS.getException();
        }
    }
}
