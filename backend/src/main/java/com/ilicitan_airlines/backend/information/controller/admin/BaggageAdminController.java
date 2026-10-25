package com.ilicitan_airlines.backend.information.controller.admin;

import com.ilicitan_airlines.backend.information.service.BaggageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/baggages")
@Tag(name = "Baggages", description = "Baggage management reserved for administrators")
public class BaggageAdminController {
    private final BaggageService baggageService;
}