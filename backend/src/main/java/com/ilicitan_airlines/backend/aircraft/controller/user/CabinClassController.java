package com.ilicitan_airlines.backend.aircraft.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cabin-class")
@Tag(name = "Cabin Class", description = "Managing in-cabin classes")
public class CabinClassController {

}