package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.BaggageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaggageService {
    private final BaggageRepository baggageRepository;
}