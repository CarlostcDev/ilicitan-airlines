package com.carlostcdev.ilicitanairlines.information.entity;

import com.carlostcdev.ilicitanairlines.flight.entity.FlightSeat;
import com.carlostcdev.ilicitanairlines.information.enums.TicketStatus;
import com.carlostcdev.ilicitanairlines.reservation.entity.ReservationFlight;
import com.carlostcdev.ilicitanairlines.reservation.entity.ReservationPassenger;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "ticket")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_flight_id", nullable = false)
    private ReservationFlight reservationFlight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_passenger_id", nullable = false)
    private ReservationPassenger reservationPassenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_seat_id")
    private FlightSeat flightSeat;

    @NotBlank
    @Pattern(regexp = "[0-9]{13}")
    @Column(name = "ticket_number", nullable = false, length = 13)
    private String ticketNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TicketStatus status;

    @NotNull
    @PositiveOrZero
    @Column(name = "base_fare", nullable = false, precision = 10, scale = 2)
    private BigDecimal baseFare;

    @NotNull
    @PositiveOrZero
    @Column(name = "taxes", nullable = false, precision = 10, scale = 2)
    private BigDecimal taxes;

    @PositiveOrZero
    @Column(name = "total_amount", insertable = false, updatable = false, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Ticket(ReservationFlight reservationFlight, ReservationPassenger reservationPassenger, FlightSeat flightSeat,
                  String ticketNumber, TicketStatus status, BigDecimal baseFare, BigDecimal taxes) {
        this.reservationFlight = reservationFlight;
        this.reservationPassenger = reservationPassenger;
        this.flightSeat = flightSeat;
        this.ticketNumber = ticketNumber;
        this.status = status != null ? status : TicketStatus.PENDING;
        this.baseFare = baseFare != null ? baseFare : BigDecimal.ZERO;
        this.taxes = taxes != null ? taxes : BigDecimal.ZERO;

    }
}
