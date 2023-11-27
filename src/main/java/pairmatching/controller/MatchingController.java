package pairmatching.controller;

import pairmatching.handler.InputHandler;
import pairmatching.handler.OutputHandler;

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
}
