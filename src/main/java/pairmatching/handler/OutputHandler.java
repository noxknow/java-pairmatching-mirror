package pairmatching.handler;

import java.util.List;

public interface OutputHandler {

    void printMenuMessage();
    void printCourseLevelMissions(List<String> courses, List<String> levelMissions);
}
