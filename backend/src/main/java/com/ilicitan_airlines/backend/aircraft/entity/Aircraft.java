package com.ilicitan_airlines.backend.aircraft.entity;

import com.ilicitan_airlines.backend.aircraft.enums.AircraftStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "aircraft")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_model_id", nullable = false)
    private AircraftModel aircraftModel;

    @NotBlank
    @Size(max = 20)
    @Column(name = "registration", nullable = false, length = 20)
    private String registration;

    @Size(max = 50)
    @Column(name = "serial_number", length = 50)
    private String serialNumber;

    @NotNull
    @Column(name = "starlink", nullable = false)
    private Boolean starlink;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AircraftStatus status = AircraftStatus.INACTIVE;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Aircraft(AircraftModel aircraftModel, String registration, String serialNumber, Boolean starlink, AircraftStatus status) {
        this.aircraftModel = aircraftModel;
        this.registration = registration;
        this.serialNumber = serialNumber;
        this.starlink = starlink != null && starlink;
        this.status = status != null ? status : AircraftStatus.INACTIVE;
    }
}
