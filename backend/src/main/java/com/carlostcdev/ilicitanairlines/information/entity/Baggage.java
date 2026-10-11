package com.carlostcdev.ilicitanairlines.information.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "baggage")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "baggage_option_id", nullable = false)
    private BaggageOption baggageOption;

    @NotNull
    @Positive
    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @NotNull
    @Positive
    @Column(name = "weight_kg", nullable = false, precision = 5, scale = 2)
    private BigDecimal weight;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Baggage(Ticket ticket, BaggageOption baggageOption, Short quantity, BigDecimal weight) {
        this.ticket = ticket;
        this.baggageOption = baggageOption;
        this.quantity = quantity;
        this.weight = weight;
    }
}
