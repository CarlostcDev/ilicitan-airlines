package com.ilicitan_airlines.backend.reservation.service;

import com.ilicitan_airlines.backend.reservation.repository.ReservationPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationPassengerService {
    private final ReservationPassengerRepository reservationPassengerRepository;
}