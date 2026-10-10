package com.carlostcdev.ilicitanairlines.flight.entity;

import com.carlostcdev.ilicitanairlines.aircraft.entity.CabinClass;
import com.carlostcdev.ilicitanairlines.validation.BuilderValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Locale;

@Entity
@Getter
@Table(name = "flight_fare")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FlightFare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cabin_class_id", nullable = false)
    private CabinClass cabinClass;

    @NotBlank
    @Pattern(regexp = "[A-Z_]{1,30}")
    @Column(name = "fare_code", nullable = false, length = 30)
    private String fareCode;

    @NotNull
    @PositiveOrZero
    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}")
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @NotNull
    @PositiveOrZero
    @Column(name = "baggage_allowance_kg", nullable = false, precision = 5, scale = 2)
    private BigDecimal baggageAllowance;

    @NotNull
    @Column(name = "refundable", nullable = false)
    private Boolean refundable;

    @NotNull
    @Column(name = "changeable", nullable = false)
    private Boolean changeable;

    @Builder
    public FlightFare(Flight flight, CabinClass cabinClass, String fareCode, BigDecimal basePrice, String currency,
                      BigDecimal baggageAllowance, Boolean refundable, Boolean changeable) {
        this.flight = BuilderValidator.validateNull(flight);
        this.cabinClass = BuilderValidator.validateNull(cabinClass);
        this.fareCode = BuilderValidator.validateNull(fareCode).toUpperCase(Locale.ROOT);
        this.basePrice = BuilderValidator.validateNull(basePrice);
        this.currency = BuilderValidator.validateNull(currency).toUpperCase(Locale.ROOT);
        this.baggageAllowance = baggageAllowance != null ? baggageAllowance : BigDecimal.ZERO;
        this.refundable = refundable != null && refundable;
        this.changeable = changeable != null && changeable;
    }
}
