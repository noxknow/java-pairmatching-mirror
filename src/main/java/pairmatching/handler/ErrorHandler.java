package pairmatching.handler;

public enum ErrorHandler {

    INVALID_PATH("존재하지 않는 경로입니다."),
    INVALID_LEVEL("일치하지 않는 레벨입니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        this.errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
