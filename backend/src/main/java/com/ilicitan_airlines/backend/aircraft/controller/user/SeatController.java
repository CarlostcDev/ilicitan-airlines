package com.ilicitan_airlines.backend.aircraft.controller.user;

import com.ilicitan_airlines.backend.aircraft.service.SeatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seats")
@Tag(name = "Seats", description = "Seat management and booking")
public class SeatController {
    private final SeatService seatService;
}