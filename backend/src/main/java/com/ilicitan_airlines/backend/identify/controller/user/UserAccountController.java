package com.ilicitan_airlines.backend.identify.controller.user;

import com.ilicitan_airlines.backend.identify.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-account")
@Tag(name = "User Accounts", description = "User account use and management")
public class UserAccountController {
    private final UserAccountService userAccountService;
}