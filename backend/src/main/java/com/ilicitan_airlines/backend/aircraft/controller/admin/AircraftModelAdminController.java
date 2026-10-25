package com.ilicitan_airlines.backend.aircraft.controller.admin;

import com.ilicitan_airlines.backend.aircraft.service.AircraftModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/aircraft-model")
@Tag(name = "Aircraft Models", description = "Management of aircraft models for administrators")
public class AircraftModelAdminController {
    private final AircraftModelService aircraftModelService;
}