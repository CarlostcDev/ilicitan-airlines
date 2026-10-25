package com.ilicitan_airlines.backend.location.controller.admin;

import com.ilicitan_airlines.backend.location.service.CityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/city")
@Tag(name = "city", description = "City management for administrators")
public class CityAdminController {
    private final CityService cityService;
}