package pairmatching.handler;

public enum ConstantsHandler {

    MIN_SIZE(0, ""),
    DEFAULT_PAIR_COUNT(2, ""),
    ODD_PAIR_COUNT(3, ""),
    ZERO_INDEX(0, ""),
    JOIN_MARK(0, " : "),
    NEW_LINE(0, "\n"),

    MATCHING_WORD(0, "1"),
    JOIN_LEVEL_MISSIONS(0, ": "),
    VERTICAL_BAR_DELIMITER(0, " | "),
    PREFIX(0, "  - "),

    COURSE_LEVEL_MISSIONS_DELIMITER(0, ", ");

    private final int value;
    private final String word;

    ConstantsHandler(int value, String word) {
        this.value = value;
        this.word = word;
    }

    public int getValue() {
        return value;
    }

    public String getWord() {
        return word;
    }
}
