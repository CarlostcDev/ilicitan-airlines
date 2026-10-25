package com.ilicitan_airlines.backend.reservation.controller.user;

import com.ilicitan_airlines.backend.reservation.service.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
@Tag(name = "Reservations", description = "Management and viewing of a user's reservations")
public class ReservationController {
    private final ReservationService reservationService;
}