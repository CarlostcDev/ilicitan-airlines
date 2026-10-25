package com.ilicitan_airlines.backend.aircraft.controller.user;

import com.ilicitan_airlines.backend.aircraft.service.AircraftModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aircraft-model")
@Tag(name = "Aircraft Models", description = "Management of aircraft models")
public class AircraftModelController {
    private final AircraftModelService aircraftModelService;
}