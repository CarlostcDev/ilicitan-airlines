package com.carlostcdev.ilicitanairlines.aircraft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Table(name = "aircraft_model")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AircraftModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "manufacturer", nullable = false, length = 100)
    private String manufacturer;

    @NotBlank
    @Size(max = 100)
    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @NotNull
    @Positive
    @Column(name = "capacity", nullable = false)
    private Short capacity;

    @Builder
    public AircraftModel(String manufacturer, String model, Short capacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
    }
}