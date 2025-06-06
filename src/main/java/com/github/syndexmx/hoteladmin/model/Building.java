package com.github.syndexmx.hoteladmin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "buildings")
public class Building {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildingId;

    private String buildingName;
    private String fullAddress;
    private Integer numberOfFloors;
    private Integer buildYear;
    private Integer maintenanceYear;
    private Boolean elevator;

    @OneToMany(cascade = CascadeType.ALL)
    private List<FloorSchema> floors;

    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
