package com.carlostcdev.ilicitanairlines.location.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

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

    @URL
    @NotBlank
    @Size(max = 500)
    @Column(name = "banner_city_url", nullable = false, length = 500)
    private String bannerCityUrl;

    @Builder
    public City(Country country, String name, String bannerCityUrl) {
        this.country = country;
        this.name = name;
        this.bannerCityUrl = bannerCityUrl;
    }
}