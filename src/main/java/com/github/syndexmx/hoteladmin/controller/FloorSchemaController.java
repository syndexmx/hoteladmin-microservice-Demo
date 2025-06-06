package com.github.syndexmx.hoteladmin.controller;

import com.github.syndexmx.hoteladmin.model.FloorSchema;
import com.github.syndexmx.hoteladmin.model.dto.FloorSchemaDto;
import com.github.syndexmx.hoteladmin.model.mapper.FloorSchemaDtoMapper;
import com.github.syndexmx.hoteladmin.service.FloorSchemaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v0/floorschemas")
public class FloorSchemaController {

    private final FloorSchemaService floorSchemaService;
    private final FloorSchemaDtoMapper floorSchemaMapper;

    public FloorSchemaController(FloorSchemaService floorSchemaService, FloorSchemaDtoMapper floorSchemaMapper) {
        this.floorSchemaService = floorSchemaService;
        this.floorSchemaMapper = floorSchemaMapper;
    }

    @PostMapping(path = "")
    public ResponseEntity<FloorSchemaDto> createFloorSchema(@RequestBody FloorSchemaDto floorSchemaDto) {
        final FloorSchemaDto createdFloorSchemaDto =
                floorSchemaMapper.toFloorSchemaDto(floorSchemaService.create(floorSchemaMapper
                        .fromFloorSchemaDto(floorSchemaDto)));
        return new ResponseEntity(createdFloorSchemaDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<FloorSchemaDto>> findFloorSchemaPaged(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size) {
        if (page == null || size == null) {
            final List<FloorSchema> resultList = floorSchemaService.findAllFloorSchemas();
            final List<FloorSchemaDto> resultsDto = floorSchemaMapper.toFloorSchemaDtoList(resultList);
            return new ResponseEntity(resultsDto, HttpStatus.OK);
        }
        final Pageable paging = PageRequest.of(page, size);
        final Page<FloorSchema> resultPage = floorSchemaService.findFloorSchemasPaged(paging);
        final List<FloorSchemaDto> resulsDto = resultPage.stream()
                .map(floorSchema -> floorSchemaMapper.toFloorSchemaDto(floorSchema))
                .toList();
        return new ResponseEntity(resulsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<FloorSchemaDto>> findFloorSchemasPaged(@PathVariable Long id) {
        final Optional<FloorSchema> floorSchemaOption = floorSchemaService.findById(id);
        if (floorSchemaOption.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
        final FloorSchemaDto resultDto = floorSchemaMapper.toFloorSchemaDto(floorSchemaOption.get());
        return new ResponseEntity(resultDto, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FloorSchemaDto> updateFloorSchema(@PathVariable Long id,
                                                      @RequestBody FloorSchemaDto floorSchemaDto) {
        if (!id.equals(floorSchemaDto.floorSchemaId())) {
            return new ResponseEntity(floorSchemaDto, HttpStatus.CONFLICT);
        }
        FloorSchema floorSchemaToUpdate = floorSchemaMapper.fromFloorSchemaDto(floorSchemaDto);
        Optional<FloorSchema> updatedFloorSchemaOptional = floorSchemaService.save(floorSchemaToUpdate);
        if (updatedFloorSchemaOptional.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_MODIFIED);
        }
        final FloorSchemaDto createdFloorSchemaDto =
                floorSchemaMapper.toFloorSchemaDto(updatedFloorSchemaOptional.get());
        return new ResponseEntity(createdFloorSchemaDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteFloorSchema(@PathVariable Long id) {
        floorSchemaService.delete(id);
        return new ResponseEntity("Deleted", HttpStatus.NO_CONTENT);
    }
}
