package com.ilicitan_airlines.backend.aircraft.controller.admin;

import com.ilicitan_airlines.backend.aircraft.dto.admin.response.AircraftModelOptionAdminResponse;
import com.ilicitan_airlines.backend.aircraft.service.AircraftModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/aircraft-models")
@Tag(name = "Aircraft Models", description = "Management of aircraft models for administrators")
public class AircraftModelAdminController {
    private final AircraftModelService aircraftModelService;

    @GetMapping("/models")
    public List<AircraftModelOptionAdminResponse> getAircraftModels() {
        return aircraftModelService.getAircraftModelOptions();
    }
}