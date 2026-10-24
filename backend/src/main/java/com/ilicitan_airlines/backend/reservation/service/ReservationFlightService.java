package com.ilicitan_airlines.backend.reservation.service;

import com.ilicitan_airlines.backend.reservation.repository.ReservationFlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationFlightService {
    private final ReservationFlightRepository reservationFlightRepository;
}