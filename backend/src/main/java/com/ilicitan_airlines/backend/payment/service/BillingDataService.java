package com.ilicitan_airlines.backend.payment.service;

import com.ilicitan_airlines.backend.payment.repository.BillingDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillingDataService {
    private final BillingDataRepository billingDataRepository;
}