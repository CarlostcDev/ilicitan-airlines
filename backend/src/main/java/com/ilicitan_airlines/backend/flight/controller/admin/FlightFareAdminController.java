package com.ilicitan_airlines.backend.flight.controller.admin;

import com.ilicitan_airlines.backend.flight.service.FlightFareService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/flight-fare")
@Tag(name = "Flight Fares", description = "Flight fare management for administrators")
public class FlightFareAdminController {
    private final FlightFareService flightFareService;
}