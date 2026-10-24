package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.CheckinRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckinService {
    private final CheckinRepository checkinRepository;

    public CheckinService(CheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }
}