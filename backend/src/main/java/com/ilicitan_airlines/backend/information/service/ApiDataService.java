package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.ApiDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ApiDataService {
    private final ApiDataRepository apiDataRepository;

    public ApiDataService(ApiDataRepository apiDataRepository) {
        this.apiDataRepository = apiDataRepository;
    }
}