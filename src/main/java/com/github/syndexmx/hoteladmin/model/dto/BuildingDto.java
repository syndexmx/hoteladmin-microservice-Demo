package com.github.syndexmx.hoteladmin.model.dto;

import com.github.syndexmx.hoteladmin.model.FloorSchema;

import java.util.List;

public record BuildingDto (

        Long buildingId,
        String buildingName,
        String fullAddress,
        Integer numberOfFloors,
        Integer buildYear,
        Integer maintenanceYear,
        Boolean elevator,

        List<FloorSchemaDto> floors

    ) {
}
