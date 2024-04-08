package hr.riteh.praksafakture.controllers.advice;

import hr.riteh.praksafakture.config.ServiceConfiguration;
import hr.riteh.praksafakture.messages.Response;
import hr.riteh.praksafakture.messages.Status;
import hr.riteh.praksafakture.messages.status.StatusCode;
import hr.riteh.praksafakture.utils.StatusUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private final ServiceConfiguration serviceConfiguration;

    @Autowired
    public ControllerAdvisor(ServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Response> handleGeneralException(Exception ex) {
        log.error("An exception has occurred: ", ex);

        String userFriendlyMessage =
                serviceConfiguration.getResourceBundle().getString(StatusCode.GENERAL_ERROR.name());
        Status status = StatusUtil.getStatus(StatusCode.GENERAL_ERROR.getCode(), userFriendlyMessage, ex);
        return new ResponseEntity<>(new Response(status), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Response> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("An IllegalArgumentException has occurred: ", ex);

        String userFriendlyMessage =
                serviceConfiguration.getResourceBundle().getString(StatusCode.INVALID_REQUEST_PARAMETERS.name());
        Status status = StatusUtil.getStatus(StatusCode.INVALID_REQUEST_PARAMETERS.getCode(), userFriendlyMessage, ex);
        return new ResponseEntity<>(new Response(status), HttpStatus.BAD_REQUEST);
    }

}
