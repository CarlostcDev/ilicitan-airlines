package com.ilicitan_airlines.backend.identify.service;

import com.ilicitan_airlines.backend.identify.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
}