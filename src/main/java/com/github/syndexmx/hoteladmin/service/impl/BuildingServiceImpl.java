package com.github.syndexmx.hoteladmin.service.impl;

import com.github.syndexmx.hoteladmin.model.Building;
import com.github.syndexmx.hoteladmin.repository.BuildingRepository;
import com.github.syndexmx.hoteladmin.service.BuildingService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public List<Building> findAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public Page<Building> findBuildingsPaged(Pageable pageable) {
        return buildingRepository.findAll(pageable);
    }

    @Override
    public Optional<Building> findById(Long id) {
        return buildingRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Building> save(Building building) {
        if (!buildingRepository.existsById(building.getBuildingId())) {
            return Optional.empty();
        }
        return Optional.ofNullable(buildingRepository.save(building));
    }

    @Override
    public void delete(Long id) {
        buildingRepository.deleteById(id);
    }
}
