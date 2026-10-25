package com.ilicitan_airlines.backend.information.controller.admin;

import com.ilicitan_airlines.backend.information.service.CheckinService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/checkins")
@Tag(name = "Checkins", description = "Check-in management for administrators")
public class CheckinAdminController {
    private final CheckinService checkinService;
}
