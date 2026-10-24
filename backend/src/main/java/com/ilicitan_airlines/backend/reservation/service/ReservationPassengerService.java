package com.ilicitan_airlines.backend.reservation.service;

import com.ilicitan_airlines.backend.reservation.repository.ReservationPassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationPassengerService {
    private final ReservationPassengerRepository reservationPassengerRepository;

    public ReservationPassengerService(ReservationPassengerRepository reservationPassengerRepository) {
        this.reservationPassengerRepository = reservationPassengerRepository;
    }
}