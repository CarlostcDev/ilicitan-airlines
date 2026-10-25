package com.ilicitan_airlines.backend.aircraft.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
@Tag(name = "Seats", description = "Seat management")
public class SeatController {

}