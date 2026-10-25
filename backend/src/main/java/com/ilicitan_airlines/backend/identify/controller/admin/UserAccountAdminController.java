package com.ilicitan_airlines.backend.identify.controller.admin;

import com.ilicitan_airlines.backend.identify.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/user-accounts")
@Tag(name = "User Accounts", description = "User account management for administrators")
public class UserAccountAdminController {
    private final UserAccountService userAccountService;
}
