package com.carlostcdev.ilicitanairlines.reservation.entity;

import com.carlostcdev.ilicitanairlines.global.enums.DocumentType;
import com.carlostcdev.ilicitanairlines.global.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "reservation_passenger")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationPassenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @NotNull
    @Positive
    @Column(name = "passenger_number", nullable = false)
    private Byte passengerNumber;

    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nationality_country", nullable = false, length = 50)
    private String nationalityCountry;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false)
    private DocumentType documentType;

    @NotBlank
    @Size(max = 50)
    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    @Email
    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "^\\+?[0-9 ()-]{7,30}$")
    @Column(name = "phone", length = 30)
    private String phone;

    @Builder
    public ReservationPassenger(Reservation reservation, Byte passengerNumber, String firstName, String lastName, LocalDate birthDate,
                                Gender gender, String nationalityCountry, DocumentType documentType,
                                String documentNumber, String email, String phone) {
        this.reservation = reservation;
        this.passengerNumber = passengerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender != null ? gender : Gender.UNSPECIFIED;
        this.nationalityCountry = nationalityCountry;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phone = phone;
    }
}
