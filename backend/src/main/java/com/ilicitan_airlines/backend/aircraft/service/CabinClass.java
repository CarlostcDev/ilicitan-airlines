package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.repository.CabinClassRepository;
import org.springframework.stereotype.Service;

@Service
public class CabinClass {
    private final CabinClassRepository cabinClassRepository;

    public CabinClass(CabinClassRepository cabinClassRepository) {
        this.cabinClassRepository = cabinClassRepository;
    }
}