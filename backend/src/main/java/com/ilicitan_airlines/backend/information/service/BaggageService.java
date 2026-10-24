package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.BaggageRepository;
import org.springframework.stereotype.Service;

@Service
public class BaggageService {
    private final BaggageRepository baggageRepository;

    public BaggageService(BaggageRepository baggageRepository) {
        this.baggageRepository = baggageRepository;
    }
}