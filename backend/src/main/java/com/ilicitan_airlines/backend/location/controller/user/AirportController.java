package com.ilicitan_airlines.backend.location.controller.user;

import com.ilicitan_airlines.backend.location.service.AirportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airport")
@Tag(name = "Airports", description = "Origin and destination airports for the flights")
public class AirportController {
    private final AirportService airportService;
}