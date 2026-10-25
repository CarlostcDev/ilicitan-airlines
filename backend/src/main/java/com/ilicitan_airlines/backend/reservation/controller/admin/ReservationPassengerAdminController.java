package com.ilicitan_airlines.backend.reservation.controller.admin;

import com.ilicitan_airlines.backend.reservation.service.ReservationPassengerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reservation-passengers")
@Tag(name = "Reservation Passengers", description = "Passenger reservation management for administrators")
public class ReservationPassengerAdminController {
    private final ReservationPassengerService reservationPassengerService;
}