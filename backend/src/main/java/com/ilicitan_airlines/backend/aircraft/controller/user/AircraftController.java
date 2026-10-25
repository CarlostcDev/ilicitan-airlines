package com.ilicitan_airlines.backend.aircraft.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft")
@Tag(name = "Aircrafts", description = "Aircraft management")
public class AircraftController {

}