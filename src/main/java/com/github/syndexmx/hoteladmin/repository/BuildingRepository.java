package com.github.syndexmx.hoteladmin.repository;

import com.github.syndexmx.hoteladmin.model.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    Page<Building> findAll(Pageable pageable);
}
