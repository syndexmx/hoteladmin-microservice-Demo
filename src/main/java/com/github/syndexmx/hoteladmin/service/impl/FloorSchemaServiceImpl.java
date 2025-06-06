package com.github.syndexmx.hoteladmin.service.impl;

import com.github.syndexmx.hoteladmin.model.FloorSchema;
import com.github.syndexmx.hoteladmin.repository.FloorSchemaRepository;
import com.github.syndexmx.hoteladmin.service.FloorSchemaService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorSchemaServiceImpl implements FloorSchemaService {

    private final FloorSchemaRepository floorSchemaRepository;

    public FloorSchemaServiceImpl(FloorSchemaRepository floorSchemaRepository) {
        this.floorSchemaRepository = floorSchemaRepository;
    }

    @Override
    public FloorSchema create(FloorSchema floorSchema) {
        return floorSchemaRepository.save(floorSchema);
    }

    @Override
    public List<FloorSchema> findAllFloorSchemas() {
        return floorSchemaRepository.findAll();
    }

    @Override
    public Page<FloorSchema> findFloorSchemasPaged(Pageable pageable) {
        return floorSchemaRepository.findAll(pageable);
    }

    @Override
    public Optional<FloorSchema> findById(Long id) {
        return floorSchemaRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<FloorSchema> save(FloorSchema floorSchema) {
        if (!floorSchemaRepository.existsById(floorSchema.getFloorSchemaId())) {
            return Optional.empty();
        }
        return Optional.ofNullable(floorSchemaRepository.save(floorSchema));
    }

    @Override
    public void delete(Long id) {
        floorSchemaRepository.deleteById(id);
    }

}
