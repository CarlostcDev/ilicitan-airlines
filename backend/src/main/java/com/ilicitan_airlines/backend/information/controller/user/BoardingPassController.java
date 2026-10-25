package com.ilicitan_airlines.backend.information.controller.user;

import com.ilicitan_airlines.backend.information.service.BoardingPassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boarding-passes")
@Tag(name = "Boarding Passes", description = "Management and viewing of the boarding pass")
public class BoardingPassController {
    private final BoardingPassService boardingPassService;
}