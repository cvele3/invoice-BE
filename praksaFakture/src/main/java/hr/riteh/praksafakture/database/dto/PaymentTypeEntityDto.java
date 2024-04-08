package hr.riteh.praksafakture.database.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PaymentTypeEntityDto {

        private Long id;
        private String type;
}
