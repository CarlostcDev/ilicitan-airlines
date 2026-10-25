package com.ilicitan_airlines.backend.logging.controller.admin;

import com.ilicitan_airlines.backend.logging.service.ActivityLogsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/admin-logs")
@Tag(name = "Admin Logs", description = "Logs, records, changes, and administrator actions")
public class AdminLogAdminController {
    private final ActivityLogsService activityLogsService;
}