package com.ilicitan_airlines.backend.aircraft.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/aircraft")
@Tag(name = "Aircrafts", description = "Aircraft management for administrators")
public class AircraftController {

}