package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.repository.AircraftModelRepository;
import org.springframework.stereotype.Service;

@Service
public class AircraftModelService {
    private final AircraftModelRepository aircraftModelRepository;

    public AircraftModelService(AircraftModelRepository aircraftModelRepository) {
        this.aircraftModelRepository = aircraftModelRepository;
    }


}
