package hr.riteh.praksafakture.controllers;

import hr.riteh.praksafakture.constants.ControllerConstants;
import hr.riteh.praksafakture.constants.PathParamConstants;
import hr.riteh.praksafakture.database.entity.UserEntity;
import hr.riteh.praksafakture.managers.UserManager;
import hr.riteh.praksafakture.requests.LoginUserRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Log4j2
@Validated
@RestController
@RequestMapping(ControllerConstants.AUTHENTICATION)
public class AuthenticationController {

    private final UserManager userManager;

    @Autowired
    public AuthenticationController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping(value = PathParamConstants.REGISTER_USER, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody UserEntity userEntity) {
        String registrationResult = userManager.registerUser(userEntity);

        if (registrationResult.equals("User registered successfully")) {
            return new ResponseEntity<>(registrationResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(registrationResult, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = PathParamConstants.LOGIN_USER, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        String loginResult = userManager.loginUser(loginUserRequest.getUsername(), loginUserRequest.getPassword());
        log.info(loginResult);

        if (loginResult.equals("Invalid credentials")) {
            return new ResponseEntity<>(Map.of("message", loginResult), HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(Map.of("message", "User logged in successfully", "username", loginUserRequest.getUsername(), "token", loginResult), HttpStatus.OK);
        }
    }
}
