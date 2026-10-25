package com.ilicitan_airlines.backend.information.controller.user;

import com.ilicitan_airlines.backend.information.service.BaggageOptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/baggage-option")
@Tag(name = "Baggage Options", description = "Obtaining and using baggage options")
public class BaggageOptionController {
    private final BaggageOptionService baggageOptionService;
}
