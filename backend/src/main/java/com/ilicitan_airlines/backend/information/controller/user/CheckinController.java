package com.ilicitan_airlines.backend.information.controller.user;

import com.ilicitan_airlines.backend.information.service.CheckinService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checkins")
@Tag(name = "Checkins", description = "Processing and providing the check-in for the passenger")
public class CheckinController {
    private final CheckinService checkinService;
}
