package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.handler.InputHandler;
import pairmatching.handler.OutputHandler;
import pairmatching.view.ConsoleInput;
import pairmatching.view.ConsoleOutPut;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final OutputHandler outputHandler = new ConsoleOutPut();

        new MatchingController(inputHandler, outputHandler).run();
    }
}
