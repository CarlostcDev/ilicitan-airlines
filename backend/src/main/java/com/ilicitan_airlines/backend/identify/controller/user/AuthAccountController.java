package com.ilicitan_airlines.backend.identify.controller.user;

import com.ilicitan_airlines.backend.identify.service.AuthAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth-accounts")
@Tag(name = "Auth Accounts", description = "Account authentication inquiry and retrieval")
public class AuthAccountController {
    private final AuthAccountService authAccountService;
}