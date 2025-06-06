package com.github.syndexmx.hoteladmin.model.mapper;

import com.github.syndexmx.hoteladmin.model.Building;
import com.github.syndexmx.hoteladmin.model.dto.BuildingDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuildingMapper {

    BuildingDto toBuildingDto(Building building);

    List<BuildingDto> toBuildingDtoList(List<Building> buildings);

    Building fromBuildingDto(BuildingDto buildingCreateDto);

}
