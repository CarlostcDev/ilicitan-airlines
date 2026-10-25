package com.ilicitan_airlines.backend.identify.controller.user;

import com.ilicitan_airlines.backend.identify.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
@Tag(name = "Roles", description = "Retrieving and obtaining user roles")
public class RoleController {
    private final RoleService roleService;
}
