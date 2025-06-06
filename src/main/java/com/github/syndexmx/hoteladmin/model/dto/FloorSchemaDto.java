package com.github.syndexmx.hoteladmin.model.dto;

public record FloorSchemaDto (

        Long floorSchemaId,
        Integer floorNumber,
        Long buildingId,
        Integer numberOfRooms

) {
}
