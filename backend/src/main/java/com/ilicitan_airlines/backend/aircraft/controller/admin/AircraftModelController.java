package com.ilicitan_airlines.backend.aircraft.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/aircraft-model")
@Tag(name = "Aircraft Models", description = "Management of aircraft models for administrators")
public class AircraftModelController {

}