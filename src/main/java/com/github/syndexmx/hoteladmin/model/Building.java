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

    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Version
    @Column(updatable = false)
    @ColumnDefault(value = "0")
    private Integer versionMvcc;

}
