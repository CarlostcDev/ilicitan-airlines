package com.ilicitan_airlines.backend.identify.controller.admin;

import com.ilicitan_airlines.backend.identify.service.AuthAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/auth-accounts")
@Tag(name = "Auth Accounts", description = "Account authentication management for administrators")
public class AuthAccountAdminController {
    private final AuthAccountService authAccountService;
}