package pairmatching.handler;

import java.util.List;

public interface OutputHandler {

    void requestMenuMessage();
    void printCourseLevelMissions(List<String> courses, List<String> levelMissions);
    void printMatchingResult(String matchingResult);
    void requestRematch();
    void printSelectInfo();
}
