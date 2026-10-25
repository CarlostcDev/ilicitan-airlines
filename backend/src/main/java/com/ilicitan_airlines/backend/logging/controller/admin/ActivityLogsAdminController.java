package com.ilicitan_airlines.backend.logging.controller.admin;

import com.ilicitan_airlines.backend.logging.dto.admin.response.ActivityLogsResponse;
import com.ilicitan_airlines.backend.logging.enums.LogLevelFilter;
import com.ilicitan_airlines.backend.logging.service.ActivityLogsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/activity-logs")
@Tag(name = "Activity Logs", description = "User and administrator logs and records for administrators")
public class ActivityLogsAdminController {
    private final ActivityLogsService activityLogsService;

    @GetMapping("/global")
    public ActivityLogsResponse getLogs(
            @RequestParam(defaultValue = "1000") @Min(1) @Max(1000) int lines,
            @RequestParam(defaultValue = "ALL") LogLevelFilter level,
            Authentication authentication
    ) {
        List<String> logLines = activityLogsService.getLastLines(lines, level);
        log.info("Administrator {} accessed the logs. Level: {}. Number of lines returned: {}",
                authentication.getName(), level, logLines.size());
        return new ActivityLogsResponse(logLines, logLines.size());
    }
}
