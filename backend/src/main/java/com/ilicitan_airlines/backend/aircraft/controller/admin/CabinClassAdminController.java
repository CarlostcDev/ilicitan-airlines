package com.ilicitan_airlines.backend.aircraft.controller.admin;

import com.ilicitan_airlines.backend.aircraft.service.CabinClassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/cabin-classes")
@Tag(name = "Cabin Classes", description = "Managing in-cabin classes for administrators")
public class CabinClassAdminController {
    private final CabinClassService cabinClassService;
}