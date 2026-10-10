package com.carlostcdev.ilicitanairlines.flights.entity;

import com.carlostcdev.ilicitanairlines.aircraft.entity.Seat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "flight_seat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FlightSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FlightSeatStatus status;

    @PositiveOrZero
    @Column(name = "extra_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal extraPrice;

    @Builder
    public FlightSeat(Flight flight, Seat seat, FlightSeatStatus status, BigDecimal extraPrice) {
        this.flight = flight;
        this.seat = seat;
        this.status = status != null ? status : FlightSeatStatus.BLOCKED;
        this.extraPrice = extraPrice != null ? extraPrice : BigDecimal.ZERO;
    }
}
