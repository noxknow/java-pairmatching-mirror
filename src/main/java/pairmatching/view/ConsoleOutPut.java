package pairmatching.view;

import pairmatching.handler.OutputHandler;

import java.util.List;

import static pairmatching.handler.ConstantsHandler.PREFIX;
import static pairmatching.handler.ConstantsHandler.VERTICAL_BAR_DELIMITER;

public class ConsoleOutPut implements OutputHandler {

    @Override
    public void requestMenuMessage() {
        System.out.println("기능을 선택하세요.\n" +
                "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료");
    }

    @Override
    public void printCourseLevelMissions(List<String> courses, List<String> levelMissions) {
        System.out.println();
        System.out.println("#############################################");
        System.out.println("과정: " + String.join(VERTICAL_BAR_DELIMITER.getWord(), courses));
        System.out.println("미션: ");

        for (String levelMission : levelMissions) {
            System.out.println(PREFIX.getWord() + levelMission);
        }

        System.out.println("#############################################");
    }

    @Override
    public void printMatchingResult(String matchingResult) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(matchingResult);
    }

    @Override
    public void requestRematch() {
        System.out.println();
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
    }

    @Override
    public void printSelectInfo() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    @Override
    public void printError(String errorMessage) {
        System.out.println();
        System.out.println(errorMessage);
        System.out.println();
    }

    @Override
    public void printClear() {
        System.out.println();
        System.out.println("초기화 되었습니다.");
        System.out.println();
    }
}
