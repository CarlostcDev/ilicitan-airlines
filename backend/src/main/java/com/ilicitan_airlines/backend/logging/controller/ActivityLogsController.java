package com.ilicitan_airlines.backend.logging.controller;

import com.ilicitan_airlines.backend.logging.dto.admin.response.ActivityLogsResponse;
import com.ilicitan_airlines.backend.logging.service.ActivityLogsService;
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

@RestController
@RequestMapping("/admin/global-logs")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ActivityLogsController {
    private final ActivityLogsService adminLogService;

    @GetMapping
    public ActivityLogsResponse getLogs(@RequestParam(defaultValue = "200") @Min(1) @Max(1000) int lines, Authentication authentication) {
        List<String> logLines = adminLogService.getLastLines(lines);
        log.info("Administrator {} accessed the logs. Number of lines returned: {}", authentication.getName(), logLines.size());
        return new ActivityLogsResponse(logLines, logLines.size());
    }
}
