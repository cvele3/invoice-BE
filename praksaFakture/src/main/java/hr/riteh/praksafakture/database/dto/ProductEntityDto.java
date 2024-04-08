package hr.riteh.praksafakture.database.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductEntityDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
}