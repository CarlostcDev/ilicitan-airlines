package com.ilicitan_airlines.backend.aircraft.controller.admin;

import com.ilicitan_airlines.backend.aircraft.service.AircraftService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/aircraft")
@Tag(name = "Aircrafts", description = "Aircraft management for administrators")
public class AircraftAdminController {
    private final AircraftService aircraftService;
}