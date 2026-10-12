package com.ilicitan_airlines.backend.payment.entity;

import com.ilicitan_airlines.backend.global.validation.BillingValidator;
import com.ilicitan_airlines.backend.payment.enums.BillingType;
import com.ilicitan_airlines.backend.reservation.entity.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "billing_data")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BillingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false, unique = true)
    private Reservation reservation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "billing_type", nullable = false)
    private BillingType billingType;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 100)
    @Column(name = "last_name", length = 100)
    private String lastName;

    @Size(max = 150)
    @Column(name = "company_name", length = 150)
    private String companyName;

    @Size(max = 50)
    @Column(name = "tax_id", length = 50)
    private String taxId;

    @NotBlank
    @Size(max = 255)
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank
    @Size(max = 100)
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9 -]{1,20}")
    @Column(name = "postal_code", nullable = false, length = 20)
    private String postalCode;

    @NotBlank
    @Size(max = 50)
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public BillingData(Reservation reservation, BillingType billingType, String firstName, String lastName, String companyName,
                       String taxId, String address, String city, String postalCode, String country) {
        this.reservation = reservation;
        this.billingType = billingType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.taxId = taxId;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        BillingValidator.validateBilling(this.billingType, this.firstName, this.lastName, this.companyName, this.taxId);
    }
}
