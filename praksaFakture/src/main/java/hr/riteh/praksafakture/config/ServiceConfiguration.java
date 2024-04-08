package hr.riteh.praksafakture.config;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

@Data
@Setter(AccessLevel.NONE)
@Component
@ConfigurationProperties
public class ServiceConfiguration {

    private ResourceBundle resourceBundle;

    @PostConstruct
    public void initialize() {
        resourceBundle = ResourceBundle.getBundle("messages");
    }
}
