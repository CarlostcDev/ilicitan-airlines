package com.carlostcdev.ilicitanairlines.reservation.entity;

import com.carlostcdev.ilicitanairlines.identify.entity.UserAccount;
import com.carlostcdev.ilicitanairlines.reservation.enums.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Getter
@Table(name = "reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @NotBlank
    @Pattern(regexp = "[0-9A-Z]{6}")
    @Column(name = "booking_reference", nullable = false, length = 6)
    private String bookingReference;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    @NotBlank
    @Email
    @Size(max = 255)
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Pattern(regexp = "^\\+?[0-9 ()-]{7,30}$")
    @Column(name = "contact_phone", length = 30)
    private String contactPhone;

    @NotNull
    @PositiveOrZero
    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @NotNull
    @Pattern(regexp = "[A-Z]{3}")
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @NotNull
    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Reservation(UserAccount userAccount, String bookingReference, ReservationStatus status, String contactEmail,
                       String contactPhone, BigDecimal totalAmount, String currency) {
        this.userAccount = userAccount;
        this.bookingReference = bookingReference != null ? bookingReference.toUpperCase(Locale.ROOT) : null;
        this.status = status != null ? status : ReservationStatus.PENDING;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.totalAmount = totalAmount != null ? totalAmount : BigDecimal.ZERO;
        this.currency = currency != null ? currency.toUpperCase(Locale.ROOT) : null;
    }
}
