package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
}