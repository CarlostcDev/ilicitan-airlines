package com.ilicitan_airlines.backend.flight.controller.admin;

import com.ilicitan_airlines.backend.flight.service.FlightService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/flights")
@Tag(name = "Flights", description = "Flight management for administrators")
public class FlightAdminController {
    private final FlightService flightService;
}