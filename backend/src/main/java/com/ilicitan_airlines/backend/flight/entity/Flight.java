package com.ilicitan_airlines.backend.flight.entity;

import com.ilicitan_airlines.backend.aircraft.entity.Aircraft;
import com.ilicitan_airlines.backend.flight.enums.FlightStatus;
import com.ilicitan_airlines.backend.flight.validation.FlightValidator;
import com.ilicitan_airlines.backend.location.entity.Airport;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.*;

@Entity
@Getter
@Table(name = "flight")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_iata", insertable = false, updatable = false)
    private String flightIata;

    @NotBlank
    @Pattern(regexp = "IL")
    @Column(name = "airline_code", nullable = false, length = 2, updatable = false)
    private String airlineCode = "IL";

    @NotBlank
    @Pattern(regexp = "^[1-9][0-9]{2}$")
    @Column(name = "flight_number", nullable = false, length = 3)
    private String flightNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_airport_id", nullable = false)
    private Airport origin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_airport_id", nullable = false)
    private Airport destination;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @NotNull
    @Column(name = "scheduled_departure_utc", nullable = false)
    private LocalDateTime scheduledDepartureUtc;

    @NotNull
    @Column(name = "scheduled_arrival_utc", nullable = false)
    private LocalDateTime scheduledArrivalUtc;

    @Column(name = "estimated_departure_utc")
    private LocalDateTime estimatedDepartureUtc;

    @Column(name = "estimated_arrival_utc")
    private LocalDateTime estimatedArrivalUtc;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FlightStatus status;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Flight(String flightNumber, Airport origin, Airport destination, Aircraft aircraft,
                  LocalDateTime scheduledDepartureUtc, LocalDateTime scheduledArrivalUtc, LocalDateTime estimatedDepartureUtc,
                  LocalDateTime estimatedArrivalUtc, FlightStatus status) {
        FlightValidator.validateSchedule(scheduledDepartureUtc, scheduledArrivalUtc);
        FlightValidator.validateEstimated(estimatedDepartureUtc, estimatedArrivalUtc);
        FlightValidator.validateAirports(origin, destination);
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.scheduledDepartureUtc = scheduledDepartureUtc;
        this.scheduledArrivalUtc = scheduledArrivalUtc;
        this.estimatedDepartureUtc = estimatedDepartureUtc;
        this.estimatedArrivalUtc = estimatedArrivalUtc;
        this.status = status != null ? status : FlightStatus.CANCELLED;
    }
}
