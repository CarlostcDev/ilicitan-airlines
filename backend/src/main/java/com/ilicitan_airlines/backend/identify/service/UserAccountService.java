package com.ilicitan_airlines.backend.identify.service;

import com.ilicitan_airlines.backend.identify.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;
}