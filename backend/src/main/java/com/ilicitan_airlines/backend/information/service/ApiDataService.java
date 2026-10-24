package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.ApiDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiDataService {
    private final ApiDataRepository apiDataRepository;
}