package pairmatching.controller;

import pairmatching.domain.wrapper.Course;
import pairmatching.domain.wrapper.LevelMissions;
import pairmatching.handler.InputHandler;
import pairmatching.handler.OutputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.handler.ConstantsHandler.JOIN_LEVEL_MISSIONS;
import static pairmatching.handler.ConstantsHandler.MATCHING_WORD;

public class MatchingController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public MatchingController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        selectMenu();
    }

    private void selectMenu() {
        outputHandler.printMenuMessage();
        String inputValue = inputHandler.inputValue();

        if (inputValue.equals(MATCHING_WORD.getWord())) {
            startMatching();
        }
    }

    private void startMatching() {

    }

    private List<String> loadCourses() {
        List<String> courses = Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());

        return courses;
    }

    private List<String> loadLevelMissions() {
        List<String> levelMissions = Arrays.stream(LevelMissions.values())
                .map(levelMission -> levelMission.getName() + JOIN_LEVEL_MISSIONS + levelMission.getMissions())
                .collect(Collectors.toList());

        return levelMissions;
    }
}
