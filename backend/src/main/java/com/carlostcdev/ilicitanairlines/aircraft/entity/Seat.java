package com.carlostcdev.ilicitanairlines.aircraft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Table(name = "seat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cabin_class_id", nullable = false)
    private CabinClass cabinClass;

    @Column(name = "seat_number", insertable = false, updatable = false)
    private String seatNumber;

    @NotNull
    @Positive
    @Column(name = "seat_row", nullable = false)
    private Short seatRow;

    @NotBlank
    @Size(max = 1)
    @Pattern(regexp = "[A-Z]")
    @Column(name = "seat_letter", nullable = false, length = 1)
    private String seatLetter;

    @Builder
    public Seat(Aircraft aircraft, CabinClass cabinClass, Short seatRow, String seatLetter) {
        this.aircraft = aircraft;
        this.cabinClass = cabinClass;
        this.seatRow = seatRow;
        this.seatLetter = seatLetter;
    }
}