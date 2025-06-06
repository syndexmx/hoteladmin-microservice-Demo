package com.github.syndexmx.hoteladmin.model.dto;

public record FloorSchemaDto (

        Long floorSchemaId,
        Integer floorNumber,
        BuildingDto building,
        Integer numberOfRooms

) {
}
