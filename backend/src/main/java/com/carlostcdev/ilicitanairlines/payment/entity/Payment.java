package com.carlostcdev.ilicitanairlines.payment.entity;

import com.carlostcdev.ilicitanairlines.payment.enums.PaymentMethod;
import com.carlostcdev.ilicitanairlines.payment.enums.PaymentStatus;
import com.carlostcdev.ilicitanairlines.reservation.entity.Reservation;
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
@Table(name = "payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false)
    private PaymentMethod method;

    @Size(max = 50)
    @Column(name = "provider", length = 50)
    private String provider;

    @NotBlank
    @Size(max = 255)
    @Column(name = "transaction_reference", nullable = false, unique = true)
    private String transactionReference;

    @NotNull
    @PositiveOrZero
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}")
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    @Column(name = "paid_at_utc")
    private LocalDateTime paidAt;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Payment(Reservation reservation, PaymentMethod method, String provider, String transactionReference, BigDecimal amount,
                   String currency, PaymentStatus status, LocalDateTime paidAt) {
        this.reservation = reservation;
        this.method = method;
        this.provider = provider;
        this.transactionReference = transactionReference;
        this.amount = amount;
        this.currency = currency;
        this.status = status != null ? status : PaymentStatus.PENDING;
        this.paidAt = paidAt;
    }
}
