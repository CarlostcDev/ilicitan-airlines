package com.ilicitan_airlines.backend.location.controller.user;

import com.ilicitan_airlines.backend.location.service.CountryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
@Tag(name = "Countries", description = "Countries of the cities of the airports")
public class CountryController {
    private final CountryService countryService;
}