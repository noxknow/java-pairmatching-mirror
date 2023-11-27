package pairmatching.view;

import pairmatching.handler.OutputHandler;

public class ConsoleOutPut implements OutputHandler {

    @Override
    public void printMenuMessage() {
        System.out.println("기능을 선택하세요.\n" +
                "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료");
    }
}
