package hu.unideb.inf.rendeles.service.mapper;

import hu.unideb.inf.rendeles.data.entity.RendelesEntity;
import hu.unideb.inf.rendeles.service.dto.RendelesAllapotDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RendelesAllapotMapper {

    @Mapping(target = "id", source = "id")
    RendelesAllapotDto rendelesEntityToAllapotDto(RendelesEntity entity);
    List<RendelesAllapotDto> rendelesEntityToAllapotList(List<RendelesEntity> entities);

    RendelesEntity rendelesAllapotDtoToEntity(RendelesAllapotDto dto);
    List<RendelesEntity> rendelesAllapotDtoListToEntityList(List<RendelesAllapotDto> dtos);
}












