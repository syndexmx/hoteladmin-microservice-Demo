package com.github.syndexmx.hoteladmin.service;

import com.github.syndexmx.hoteladmin.model.FloorSchema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FloorSchemaService {

    public FloorSchema create(FloorSchema floorSchema);
    public List<FloorSchema> findAllFloorSchemas();
    public Page<FloorSchema> findFloorSchemasPaged(Pageable pageable);
    public Optional<FloorSchema> findById(Long id);
    public Optional<FloorSchema> save(FloorSchema floorSchema);
    public void delete(Long id);
}
