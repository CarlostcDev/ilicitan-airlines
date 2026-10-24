package com.ilicitan_airlines.backend.flight.service;

import com.ilicitan_airlines.backend.flight.repository.FlightFareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightFareService {
    private final FlightFareRepository flightFareRepository;
}