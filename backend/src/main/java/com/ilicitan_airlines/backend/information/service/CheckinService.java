package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckinService {
    private final CheckinRepository checkinRepository;
}