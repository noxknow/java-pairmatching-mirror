package pairmatching.view;

import pairmatching.handler.InputHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements InputHandler {

    @Override
    public String inputValue() {
        return readLine();
    }
}
