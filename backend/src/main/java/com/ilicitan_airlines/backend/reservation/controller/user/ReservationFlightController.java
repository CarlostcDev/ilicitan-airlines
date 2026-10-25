package com.ilicitan_airlines.backend.reservation.controller.user;

import com.ilicitan_airlines.backend.reservation.service.ReservationFlightService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation-flights")
@Tag(name = "Reservation Flights", description = "Managing a user's flight reservations")
public class ReservationFlightController {
    private final ReservationFlightService reservationFlightService;
}