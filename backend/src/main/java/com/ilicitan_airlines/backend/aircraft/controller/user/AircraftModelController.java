package com.ilicitan_airlines.backend.aircraft.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/aircraft-model")
@Tag(name = "Aircraft Models", description = "Management of aircraft models")
public class AircraftModelController {

}