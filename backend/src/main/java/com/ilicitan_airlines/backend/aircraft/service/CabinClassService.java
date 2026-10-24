package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.repository.CabinClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CabinClassService {
    private final CabinClassRepository cabinClassRepository;

}