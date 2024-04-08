package hr.riteh.praksafakture.utils;

import hr.riteh.praksafakture.messages.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StatusUtil {

    public static Status getStatus(int statusCode, String userFriendlyMessage, Exception ex) {
        String exceptionMessage = "";

        if (ex != null) {
            if (ex.getCause() != null) {
                exceptionMessage = ex.getCause().getClass().getName() + ": " + ex.getCause().getMessage();
            } else {
                exceptionMessage = ex.getClass().getName() + ": " + ex.getMessage();
            }
        }

        return new Status(statusCode, userFriendlyMessage, exceptionMessage);
    }
}
