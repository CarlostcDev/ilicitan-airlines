package com.ilicitan_airlines.backend.reservation.controller.admin;

import com.ilicitan_airlines.backend.reservation.service.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reservations")
@Tag(name = "Reservations", description = "Reservation management for administrators")
public class ReservationAdminController {
    private final ReservationService reservationService;
}