package com.ilicitan_airlines.backend.reservation.service;

import com.ilicitan_airlines.backend.reservation.repository.ReservationFlightRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationFlightService {
    private final ReservationFlightRepository reservationFlightRepository;

    public ReservationFlightService(ReservationFlightRepository reservationFlightRepository) {
        this.reservationFlightRepository = reservationFlightRepository;
    }
}