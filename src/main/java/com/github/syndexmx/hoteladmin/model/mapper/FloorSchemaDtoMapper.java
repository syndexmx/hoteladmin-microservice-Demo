package com.github.syndexmx.hoteladmin.model.mapper;

import com.github.syndexmx.hoteladmin.model.FloorSchema;
import com.github.syndexmx.hoteladmin.model.dto.FloorSchemaDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FloorSchemaDtoMapper {

    FloorSchemaDto toFloorSchemaDto(FloorSchema floorSchema);

    List<FloorSchemaDto> toFloorSchemaDtoList(List<FloorSchema> floorSchemas);

    FloorSchema fromFloorSchemaDto(FloorSchemaDto floorSchemaDto);
}
