package com.ilicitan_airlines.backend.flight.controller.user;

import com.ilicitan_airlines.backend.flight.service.FlightFareService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flight-fare")
@Tag(name = "Flight Fares", description = "Flight fare management and consultation")
public class FlightFareController {
    private final FlightFareService flightFareService;
}