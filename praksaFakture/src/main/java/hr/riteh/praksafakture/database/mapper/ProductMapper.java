package hr.riteh.praksafakture.database.mapper;

import hr.riteh.praksafakture.database.dto.ProductEntityDto;
import hr.riteh.praksafakture.database.entity.ProductEntity;
import org.mapstruct.*;

import static hr.riteh.praksafakture.constants.MapperConstants.COMPONENT_MODEL;

@Mapper(componentModel = COMPONENT_MODEL)
public interface ProductMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    ProductEntity update(@MappingTarget ProductEntity productEntity, ProductEntityDto productEntityDto);
}
