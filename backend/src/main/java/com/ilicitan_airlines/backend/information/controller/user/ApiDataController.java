package com.ilicitan_airlines.backend.information.controller.user;

import com.ilicitan_airlines.backend.information.service.ApiDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-data")
@Tag(name = "Api Data", description = "management and modification of API information")
public class ApiDataController {
    private final ApiDataService apiDataService;
}