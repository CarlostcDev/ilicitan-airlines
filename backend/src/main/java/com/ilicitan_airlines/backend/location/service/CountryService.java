package com.ilicitan_airlines.backend.location.service;

import com.ilicitan_airlines.backend.location.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}