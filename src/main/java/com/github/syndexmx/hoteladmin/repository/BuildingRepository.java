package com.github.syndexmx.hoteladmin.repository;

import com.github.syndexmx.hoteladmin.model.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    @EntityGraph(attributePaths = {"floors"})
    Page<Building> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"floors"})
    Optional<Building> findById(Long id);

    @EntityGraph(attributePaths = {"floors"})
    List<Building> findAll();

}
