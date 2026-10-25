package com.ilicitan_airlines.backend.location.controller.admin;

import com.ilicitan_airlines.backend.location.service.AirportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/airports")
@Tag(name = "Airports", description = "Airport management for administrators")
public class AirportAdminController {
    private final AirportService airportService;
}