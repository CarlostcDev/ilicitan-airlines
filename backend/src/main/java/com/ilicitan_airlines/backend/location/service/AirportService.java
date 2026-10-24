package com.ilicitan_airlines.backend.location.service;

import com.ilicitan_airlines.backend.location.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
}