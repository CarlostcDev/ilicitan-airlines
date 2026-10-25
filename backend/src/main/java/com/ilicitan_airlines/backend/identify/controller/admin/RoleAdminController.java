package com.ilicitan_airlines.backend.identify.controller.admin;

import com.ilicitan_airlines.backend.identify.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/roles")
@Tag(name = "Roles", description = "User role management for administrators")
public class RoleAdminController {
    private final RoleService roleService;
}
