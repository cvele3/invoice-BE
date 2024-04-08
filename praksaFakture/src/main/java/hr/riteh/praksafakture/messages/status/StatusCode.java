package hr.riteh.praksafakture.messages.status;

public enum StatusCode {
    NO_ERROR(0),
    NONEXISTENT_ENTITY(100),
    INVALID_REQUEST_PARAMETERS(400),
    GENERAL_ERROR(500);

    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}