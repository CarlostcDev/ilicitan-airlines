package com.ilicitan_airlines.backend.location.controller.user;

import com.ilicitan_airlines.backend.location.service.CityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
@Tag(name = "city", description = "Cities where the airports are located")
public class CityController {
    private final CityService cityService;
}