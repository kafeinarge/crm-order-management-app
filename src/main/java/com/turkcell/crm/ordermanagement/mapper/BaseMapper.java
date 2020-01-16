package com.turkcell.crm.ordermanagement.mapper;

import com.turkcell.crm.ordermanagement.dto.BaseDTO;
import com.crm.ordermanagementapp.crm.entity.base.BaseEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper<Entity extends BaseEntity, DTO extends BaseDTO>  {

    @Named("toEntity")
    @Mapping(target = "creationDate", ignore = true)
    Entity toEntity(DTO dto);

    @Named("toDTO")
    DTO toDTO(Entity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Entity> toEntityList(List<DTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<DTO> toDTOList(List<Entity> entityList);

}
