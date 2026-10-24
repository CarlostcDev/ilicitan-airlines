package com.ilicitan_airlines.backend.location.service;

import com.ilicitan_airlines.backend.location.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
}