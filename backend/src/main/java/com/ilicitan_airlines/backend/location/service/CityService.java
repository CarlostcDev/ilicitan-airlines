package com.ilicitan_airlines.backend.location.service;

import com.ilicitan_airlines.backend.location.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}