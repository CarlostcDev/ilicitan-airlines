package com.ilicitan_airlines.backend.flight.controller.user;

import com.ilicitan_airlines.backend.flight.service.FlightSeatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flight-seats")
@Tag(name = "Flight Seats", description = "Flight seat search")
public class FlightSeatController {
    private final FlightSeatService flightSeatService;
}