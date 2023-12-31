package pairmatching.handler;

public enum ErrorHandler {

    INVALID_PATH("존재하지 않는 경로입니다."),
    INVALID_COURSE("존재하지 않는 과정입니다."),
    INVALID_LEVEL_MISSIONS("레벨 혹은 미션이 일치하지 않습니다."),
    INVALID_FORMAT("입력 양식이 올바르지 않습니다."),
    INVALID_MATCH("페어를 매칭할 수 없습니다."),
    INVALID_TO_FIND_RESULT("매칭 이력이 없습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        this.errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
