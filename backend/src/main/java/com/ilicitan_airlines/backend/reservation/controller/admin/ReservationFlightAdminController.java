package com.ilicitan_airlines.backend.reservation.controller.admin;

import com.ilicitan_airlines.backend.reservation.service.ReservationFlightService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reservation-flights")
@Tag(name = "Reservation Flights", description = "Flight reservation management for administrators")
public class ReservationFlightAdminController {
    private final ReservationFlightService reservationFlightService;
}