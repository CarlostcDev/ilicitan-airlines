package com.carlostcdev.ilicitanairlines.information.entity;

import com.carlostcdev.ilicitanairlines.global.enums.DocumentType;
import com.carlostcdev.ilicitanairlines.global.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "api_data")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false)
    private DocumentType documentType;

    @NotBlank
    @Size(max = 50)
    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    @NotBlank
    @Size(max = 50)
    @Column(name = "issuing_country", nullable = false, length = 50)
    private String issuingCountry;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nationality_country", nullable = false, length = 50)
    private String nationalityCountry;

    @NotNull
    @Column(name = "document_expiry_date", nullable = false)
    private LocalDate documentExpiryDate;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public ApiData(Ticket ticket, DocumentType documentType, String documentNumber, String issuingCountry,
                   String nationalityCountry, LocalDate documentExpiryDate, LocalDate birthDate, Gender gender) {
        this.ticket = ticket;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuingCountry = issuingCountry;
        this.nationalityCountry = nationalityCountry;
        this.documentExpiryDate = documentExpiryDate;
        this.birthDate = birthDate;
        this.gender = gender != null ? gender : Gender.UNSPECIFIED;
    }
}
