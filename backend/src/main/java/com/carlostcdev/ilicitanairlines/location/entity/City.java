package com.carlostcdev.ilicitanairlines.location.entity;

import com.carlostcdev.ilicitanairlines.validation.BuilderValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "city")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 500)
    @Column(name = "banner_city_url", length = 500)
    private String bannerCityUrl;

    @Builder
    public City(Country country, String name, String bannerCityUrl) {
        this.country = BuilderValidator.validateNull(country);
        this.name = BuilderValidator.validateNull(name);
        this.bannerCityUrl = bannerCityUrl;
    }
}