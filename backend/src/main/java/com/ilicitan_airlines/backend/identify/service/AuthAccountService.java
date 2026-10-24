package com.ilicitan_airlines.backend.identify.service;

import com.ilicitan_airlines.backend.identify.repository.AuthAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthAccountService {
    private final AuthAccountRepository authAccountRepository;

    public AuthAccountService(AuthAccountRepository authAccountRepository) {
        this.authAccountRepository = authAccountRepository;
    }
}