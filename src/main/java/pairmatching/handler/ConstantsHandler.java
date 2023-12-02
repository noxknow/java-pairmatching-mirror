package pairmatching.handler;

public enum ConstantsHandler {

    MIN_SIZE(0, ""),
    DEFAULT_PAIR_COUNT(2, ""),
    ODD_PAIR_COUNT(3, ""),
    ZERO_INDEX(0, ""),
    FIRST_INDEX(1, ""),
    SECOND_INDEX(2, ""),
    JOIN_MARK(0, " : "),
    NEW_LINE(0, "\n"),

    MATCHING_WORD(0, "1"),
    VIEW_WORD(0, "2"),
    QUIT_WORD(0, "Q"),
    JOIN_LEVEL_MISSIONS(0, ": "),
    VERTICAL_BAR_DELIMITER(0, " | "),
    PREFIX(0, "  - "),

    COURSE_LEVEL_MISSIONS_DELIMITER(0, ", "),
    INIT_TRY_COUNT(0, ""),
    DO_NOT_REMATCH(0, "아니오"),
    OVER_TRY_COUNT(4, ""),
    MAX_TRY_COUNT(3, ""),
    INCREMENT_TRY_COUNT(1, "");

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
