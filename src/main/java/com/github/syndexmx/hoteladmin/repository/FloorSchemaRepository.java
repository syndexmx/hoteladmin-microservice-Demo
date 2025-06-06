package com.github.syndexmx.hoteladmin.repository;

import com.github.syndexmx.hoteladmin.model.FloorSchema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorSchemaRepository extends JpaRepository<FloorSchema, Long> {

    Page<FloorSchema> findAll(Pageable pageable);
}
