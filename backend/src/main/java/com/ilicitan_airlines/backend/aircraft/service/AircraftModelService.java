package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.repository.AircraftModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AircraftModelService {
    private final AircraftModelRepository aircraftModelRepository;

}
