package com.ilicitan_airlines.backend.location.service;

import com.ilicitan_airlines.backend.location.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
}