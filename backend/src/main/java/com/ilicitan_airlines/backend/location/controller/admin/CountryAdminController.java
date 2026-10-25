package com.ilicitan_airlines.backend.location.controller.admin;

import com.ilicitan_airlines.backend.location.service.CountryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/countries")
@Tag(name = "Countries", description = "Country management for administrators")
public class CountryAdminController {
    private final CountryService countryService;
}