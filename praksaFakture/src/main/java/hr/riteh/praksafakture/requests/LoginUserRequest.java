package hr.riteh.praksafakture.requests;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String username;
    private String password;
}
