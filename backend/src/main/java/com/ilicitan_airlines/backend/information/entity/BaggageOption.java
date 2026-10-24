package com.ilicitan_airlines.backend.information.entity;

import com.ilicitan_airlines.backend.information.enums.BaggageStatus;
import com.ilicitan_airlines.backend.information.enums.BaggageType;
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
@Table(name = "baggage_option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaggageOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private BaggageType type;

    @NotNull
    @Positive
    @Column(name = "weight_kg", nullable = false, precision = 5, scale = 2)
    private BigDecimal weight;

    @NotNull
    @Positive
    @Column(name = "length_cm", nullable = false)
    private Short length;

    @NotNull
    @Positive
    @Column(name = "width_cm", nullable = false)
    private Short width;

    @NotNull
    @Positive
    @Column(name = "height_cm", nullable = false)
    private Short height;

    @NotNull
    @Positive
    @Column(name = "price_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}")
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BaggageStatus status;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public BaggageOption(String name, BaggageType type, BigDecimal weight, Short length, Short width,
                         Short height, BigDecimal price, String currency, BaggageStatus status) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
        this.currency = currency;
        this.status = status != null ? status : BaggageStatus.INACTIVE;
    }

    public void updateBaggageOption(String name, BaggageType type, BigDecimal weight, Short length, Short width,
                                    Short height, BigDecimal price, String currency, BaggageStatus status) {
        if (name != null) this.name = name;
        if (type != null) this.type = type;
        if (weight != null) this.weight = weight;
        if (length != null) this.length = length;
        if (width != null) this.width = width;
        if (height != null) this.height = height;
        if (price != null) this.price = price;
        if (currency != null) this.currency = currency;
        if (status != null) this.status = status;
    }
}
