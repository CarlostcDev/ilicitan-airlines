package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.repository.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class Seat {
    private final SeatRepository seatRepository;

    public Seat(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
}