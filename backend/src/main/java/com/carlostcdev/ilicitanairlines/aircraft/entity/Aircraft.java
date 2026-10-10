package com.carlostcdev.ilicitanairlines.aircraft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AircraftStatus status = AircraftStatus.INACTIVE;

    @Builder
    public Aircraft(AircraftModel aircraftModel, String registration, String serialNumber, AircraftStatus status) {
        this.aircraftModel = aircraftModel;
        this.registration = registration;
        this.serialNumber = serialNumber;
        this.status = status != null ? status : AircraftStatus.INACTIVE;
    }
}
