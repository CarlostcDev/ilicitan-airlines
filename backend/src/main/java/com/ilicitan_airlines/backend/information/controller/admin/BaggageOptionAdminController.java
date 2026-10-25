package com.ilicitan_airlines.backend.information.controller.admin;

import com.ilicitan_airlines.backend.information.service.BaggageOptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/baggage-option")
@Tag(name = "Baggage Options", description = "Management of baggage options for administrators")
public class BaggageOptionAdminController {
    private final BaggageOptionService baggageOptionService;
}
