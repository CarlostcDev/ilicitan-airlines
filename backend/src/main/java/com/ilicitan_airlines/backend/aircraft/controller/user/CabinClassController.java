package com.ilicitan_airlines.backend.aircraft.controller.user;

import com.ilicitan_airlines.backend.aircraft.service.CabinClassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cabin-class")
@Tag(name = "Cabin Class", description = "Managing in-cabin classes")
public class CabinClassController {
    private final CabinClassService cabinClassService;
}