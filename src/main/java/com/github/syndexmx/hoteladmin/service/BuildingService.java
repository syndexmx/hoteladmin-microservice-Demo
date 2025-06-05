package com.github.syndexmx.hoteladmin.service;

import com.github.syndexmx.hoteladmin.model.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BuildingService {

    public Building create(Building building);
    public List<Building> findAllBuildings();
    public Page<Building> findBuildingsPaged(Pageable pageable);
    public Optional<Building> findById(Long id);
    public Optional<Building> save(Building building);
    public void delete(Long id);

}
