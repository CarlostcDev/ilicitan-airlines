package com.ilicitan_airlines.backend.logging.service;

import com.ilicitan_airlines.backend.logging.repository.AdminLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminLogService {
    private final AdminLogRepository adminLogRepository;

    AdminLogService(AdminLogRepository adminLogRepository) {
        this.adminLogRepository = adminLogRepository;
    }
}