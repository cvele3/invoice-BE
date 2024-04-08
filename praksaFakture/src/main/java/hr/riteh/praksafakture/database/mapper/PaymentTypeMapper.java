package hr.riteh.praksafakture.database.mapper;

import hr.riteh.praksafakture.database.dto.PaymentTypeEntityDto;
import hr.riteh.praksafakture.database.entity.PaymentTypeEntity;
import org.mapstruct.*;

import static hr.riteh.praksafakture.constants.MapperConstants.COMPONENT_MODEL;

@Mapper(componentModel = COMPONENT_MODEL)
public interface PaymentTypeMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    PaymentTypeEntity update(@MappingTarget PaymentTypeEntity paymentTypeEntity, PaymentTypeEntityDto paymentTypeEntityDto);
}
