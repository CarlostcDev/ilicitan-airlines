package com.ilicitan_airlines.backend.reservation.controller.user;

import com.ilicitan_airlines.backend.reservation.service.ReservationPassengerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation-passengers")
@Tag(name = "Reservation Passengers", description = "Flight reservation management per passenger on the booking")
public class ReservationPassengerController {
    private final ReservationPassengerService reservationPassengerService;
}