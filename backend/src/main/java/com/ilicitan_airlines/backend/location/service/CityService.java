package com.ilicitan_airlines.backend.location.service;

import com.ilicitan_airlines.backend.location.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
}