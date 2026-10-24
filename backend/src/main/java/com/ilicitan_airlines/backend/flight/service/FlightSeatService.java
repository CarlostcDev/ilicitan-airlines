package com.ilicitan_airlines.backend.flight.service;

import com.ilicitan_airlines.backend.flight.repository.FlightSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightSeatService {
    private final FlightSeatRepository flightSeatRepository;
}