package pairmatching.controller;

import pairmatching.domain.PairsGroup;
import pairmatching.domain.PairsInfo;
import pairmatching.domain.wrapper.Course;
import pairmatching.domain.wrapper.CourseLevelMissions;
import pairmatching.domain.wrapper.Crews;
import pairmatching.domain.wrapper.LevelMissions;
import pairmatching.handler.InputHandler;
import pairmatching.handler.OutputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.handler.ConstantsHandler.*;
import static pairmatching.handler.ErrorHandler.INVALID_MATCH;

public class MatchingController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public MatchingController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.requestMenuMessage();

        PairsGroup pairsGroup = PairsGroup.create();

        selectMenu(pairsGroup);
    }

    private void selectMenu(PairsGroup pairsGroup) {
        String inputMenu = inputHandler.inputValue();

        if (inputMenu.equals(MATCHING_WORD.getWord())) {
            startMatching(pairsGroup);
        } else if (inputMenu.equals(QUIT_WORD.getWord())) {
            return;
        }

        run();
    }

    private void startMatching(PairsGroup pairsGroup) {
        showCourseLevelMissions();

        createRandomPairs(pairsGroup, INIT_TRY_COUNT.getValue());
    }

    private void showCourseLevelMissions() {
        List<String> courses = loadCourses();
        List<String> levelMissions = loadLevelMissions();
        outputHandler.printCourseLevelMissions(courses, levelMissions);
    }

    private List<String> loadCourses() {
        List<String> courses = Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());

        return courses;
    }

    private List<String> loadLevelMissions() {
        List<String> levelMissions = Arrays.stream(LevelMissions.values())
                .map(levelMission -> levelMission.getName() + JOIN_LEVEL_MISSIONS.getWord() + String.join(VERTICAL_BAR_DELIMITER.getWord(), levelMission.getMissions()))
                .collect(Collectors.toList());

        return levelMissions;
    }

    private CourseLevelMissions loadCourseLevelMissions() {
        outputHandler.printSelectInfo();
        String inputValue = inputHandler.inputValue();

        return CourseLevelMissions.from(inputValue);
    }

    private Crews loadCrews(CourseLevelMissions courseLevelMissions) {
        String course = courseLevelMissions.getCourse();
        String courseName = Course.getCourse(course).name();

        return Crews.from(courseName.toLowerCase());
    }

    private PairsInfo loadPairsInfo(CourseLevelMissions courseLevelMissions, Crews crews) {
        String course = courseLevelMissions.getCourse();
        String level = courseLevelMissions.getLevel();
        String mission = courseLevelMissions.getMission();
        List<String> crewNames = crews.getCrews();

        return PairsInfo.of(crewNames, course, level, mission);
    }

    private boolean checkPairs(CourseLevelMissions courseLevelMissions, PairsGroup pairsGroup) {
        String course = courseLevelMissions.getCourse();
        String level = courseLevelMissions.getLevel();
        String mission = courseLevelMissions.getMission();

        if (pairsGroup.havePairs(course, level, mission)) {
            outputHandler.requestRematch();
            String inputRematch = inputHandler.inputValue();
            return inputRematch.equals(DO_NOT_REMATCH.getWord());
        }

        return false;
    }

    private void createRandomPairs(PairsGroup pairsGroup, int tryCount) {
        boolean existPairs = true;
        PairsInfo pairsInfo = null;

        while (existPairs && tryCount < OVER_TRY_COUNT.getValue()) {
            tryCount += 1;
            CourseLevelMissions courseLevelMissions = loadCourseLevelMissions();
            Crews crews = loadCrews(courseLevelMissions);
            pairsInfo = loadPairsInfo(courseLevelMissions, crews);

            existPairs = checkPairs(courseLevelMissions, pairsGroup);
        }

        pairsWithRetry(pairsGroup, pairsInfo, tryCount);
    }

    private void pairsWithRetry(PairsGroup pairsGroup, PairsInfo pairsInfo, int tryCount) {
        boolean retry = pairsGroup.checkDuplicatePairs(pairsInfo);

        if (tryCount >= MAX_TRY_COUNT.getValue()) {
            outputHandler.printError(INVALID_MATCH.getException().getMessage());
            return;
        }

        if (retry) {
            createRandomPairs(pairsGroup, tryCount+1);
        } else if (!retry) {
            pairsGroup.addPairs(pairsInfo);
            outputHandler.printMatchingResult(pairsInfo.getMatchingResult());
        }
    }
}
