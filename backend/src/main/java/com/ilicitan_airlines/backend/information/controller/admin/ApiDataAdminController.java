package com.ilicitan_airlines.backend.information.controller.admin;

import com.ilicitan_airlines.backend.information.service.ApiDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/api-data")
@Tag(name = "Api Data", description = "Information management API for administrators")
public class ApiDataAdminController {
    private final ApiDataService apiDataService;
}