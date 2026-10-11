package com.carlostcdev.ilicitanairlines.location.entity;

import com.carlostcdev.ilicitanairlines.location.enums.AirportStatus;
import com.carlostcdev.ilicitanairlines.global.validation.AirportValidator;
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
@Table(name = "airport")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @NotBlank
    @Size(max = 150)
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}")
    @Column(name = "iata_code", nullable = false, length = 3)
    private String iataCode;

    @NotBlank
    @Size(max = 64)
    @Column(name = "timezone", nullable = false, length = 64)
    private String timezone;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AirportStatus status;

    @Builder
    public Airport(City city, String name, String iataCode, String timezone,
                   BigDecimal latitude, BigDecimal longitude, AirportStatus status) {
        this.city = city;
        this.name = name;
        this.iataCode = iataCode != null ? iataCode.toUpperCase(Locale.ROOT): null;
        this.timezone = timezone;
        this.latitude = AirportValidator.checkCoords(latitude, -90, 90) ? latitude : null;
        this.longitude = AirportValidator.checkCoords(longitude, -180, 180) ? longitude : null;
        this.status = status != null ? status : AirportStatus.INACTIVE;
    }
}
