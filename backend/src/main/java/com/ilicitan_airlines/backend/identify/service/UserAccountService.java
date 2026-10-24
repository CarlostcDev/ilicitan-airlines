package com.ilicitan_airlines.backend.identify.service;

import com.ilicitan_airlines.backend.identify.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
}