package com.ilicitan_airlines.backend.information.controller.admin;

import com.ilicitan_airlines.backend.information.service.BoardingPassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/boarding-passes")
@Tag(name = "Boarding Passes", description = "Boarding pass management for administrators")
public class BoardingPassAdminController {
    private final BoardingPassService boardingPassService;
}