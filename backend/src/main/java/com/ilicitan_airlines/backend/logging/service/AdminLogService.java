package com.ilicitan_airlines.backend.logging.service;

import com.ilicitan_airlines.backend.logging.repository.AdminLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLogService {
    private final AdminLogRepository adminLogRepository;
}