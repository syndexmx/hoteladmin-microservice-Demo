package com.github.syndexmx.hoteladmin.controller;

import com.github.syndexmx.hoteladmin.model.Building;
import com.github.syndexmx.hoteladmin.model.dto.BuildingDto;
import com.github.syndexmx.hoteladmin.model.mapper.BuildingMapper;
import com.github.syndexmx.hoteladmin.service.BuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v0/buildings")
public class BuildingController {

    private final BuildingService buildingService;
    private final BuildingMapper buildingMapper;

    public BuildingController(BuildingService buildingService, BuildingMapper buildingMapper) {
        this.buildingService = buildingService;
        this.buildingMapper = buildingMapper;
    }

    @PostMapping(path = "")
    public ResponseEntity<BuildingDto> createBuilding(@RequestBody BuildingDto buildingDto) {
        final BuildingDto createdBuildingDto =
                buildingMapper.toBuildingDto(buildingService.create(buildingMapper
                        .fromBuildingDto(buildingDto)));
        return new ResponseEntity(createdBuildingDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<BuildingDto>> findBuildingsPaged(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size) {
        if (page == null || size == null) {
            final List<Building> resultList = buildingService.findAllBuildings();
            final List<BuildingDto> resultsDto = buildingMapper.toBuildingDtoList(resultList);
            return new ResponseEntity(resultsDto, HttpStatus.OK);
        }
        final Pageable paging = PageRequest.of(page, size);
        final Page<Building> resultPage = buildingService.findBuildingsPaged(paging);
        final List<BuildingDto> resulsDto = resultPage.stream()
                .map(building -> buildingMapper.toBuildingDto(building))
                .toList();
        return new ResponseEntity(resulsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<BuildingDto>> findBuildingsPaged(@PathVariable Long id) {
        final Optional<Building> buildingOption = buildingService.findById(id);
        if (buildingOption.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
        final BuildingDto resultDto = buildingMapper.toBuildingDto(buildingOption.get());
        return new ResponseEntity(resultDto, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BuildingDto> updateBuilding(@PathVariable Long id,
                                                      @RequestBody BuildingDto buildingDto) {
        if (!id.equals(buildingDto.buildingId())) {
            return new ResponseEntity(buildingDto, HttpStatus.CONFLICT);
        }
        Building buildingToUpdate = buildingMapper.fromBuildingDto(buildingDto);
        Optional<Building> updatedBuildingOptional = buildingService.save(buildingToUpdate);
        if (updatedBuildingOptional.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_MODIFIED);
        }
        final BuildingDto createdBuildingDto =
                buildingMapper.toBuildingDto(updatedBuildingOptional.get());
        return new ResponseEntity(createdBuildingDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBuilding(@PathVariable Long id) {
        buildingService.delete(id);
        return new ResponseEntity("Deleted", HttpStatus.NO_CONTENT);
    }

}
