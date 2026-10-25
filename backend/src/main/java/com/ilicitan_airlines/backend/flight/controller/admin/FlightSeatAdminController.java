package com.ilicitan_airlines.backend.flight.controller.admin;

import com.ilicitan_airlines.backend.flight.service.FlightSeatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/flight-seats")
@Tag(name = "Flight Seats", description = "Flight seat management for administrators")
public class FlightSeatAdminController {
    private final FlightSeatService flightSeatService;
}