package com.ilicitan_airlines.backend.identify.service;

import com.ilicitan_airlines.backend.identify.repository.AuthAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthAccountService {
    private final AuthAccountRepository authAccountRepository;
}