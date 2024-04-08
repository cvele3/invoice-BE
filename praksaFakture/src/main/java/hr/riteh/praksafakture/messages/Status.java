package hr.riteh.praksafakture.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private int statusCode;
    private String userFriendlyMessage;
    private String exceptionMessage;

    @Override
    public String toString() {
        return "Status{code=" + statusCode + ", message='" + userFriendlyMessage + "' + exceptionMessage='" + exceptionMessage + "'}";
    }

}
