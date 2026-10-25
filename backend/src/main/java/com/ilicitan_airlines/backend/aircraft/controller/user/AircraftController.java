package com.ilicitan_airlines.backend.aircraft.controller.user;

import com.ilicitan_airlines.backend.aircraft.service.AircraftService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aircrafts")
@Tag(name = "Aircrafts", description = "Aircraft management")
public class AircraftController {
    private final AircraftService aircraftService;
}