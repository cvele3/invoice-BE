package hr.riteh.praksafakture.messages;

import hr.riteh.praksafakture.utils.RestTimeUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Response {
    private Status status;

    private String timestamp;

    public Response(Status status) {
        this.setStatus(status);
        this.timestamp = RestTimeUtil.getCurrentDateTime();
    }
}
