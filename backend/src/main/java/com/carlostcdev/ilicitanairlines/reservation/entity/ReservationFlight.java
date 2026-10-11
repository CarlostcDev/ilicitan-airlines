package com.carlostcdev.ilicitanairlines.reservation.entity;

import com.carlostcdev.ilicitanairlines.flight.entity.Flight;
import com.carlostcdev.ilicitanairlines.flight.entity.FlightFare;
import com.carlostcdev.ilicitanairlines.reservation.enums.ReservationFlightStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "reservation_flight")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_fare_id", nullable = false)
    private FlightFare flightFare;

    @NotNull
    @Positive
    @Column(name = "segment_number", nullable = false)
    private Byte segmentNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationFlightStatus status;

    @NotNull
    @PositiveOrZero
    @Column(name = "price_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceAmount;

    @Builder
    public ReservationFlight(Reservation reservation, Flight flight, FlightFare flightFare, Byte segmentNumber,
                             ReservationFlightStatus status, BigDecimal priceAmount) {
        this.reservation = reservation;
        this.flight = flight;
        this.flightFare = flightFare;
        this.segmentNumber = segmentNumber;
        this.status = status != null ? status : ReservationFlightStatus.PENDING;
        this.priceAmount = priceAmount;
    }
}
