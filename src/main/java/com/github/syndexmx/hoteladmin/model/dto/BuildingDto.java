package com.github.syndexmx.hoteladmin.model.dto;

public record BuildingDto (

    Long buildingId,
    String buildingName,
    String fullAddress,
    Integer numberOfFloors,
    Integer buildYear,
    Integer maintenanceYear

    ) {
}
