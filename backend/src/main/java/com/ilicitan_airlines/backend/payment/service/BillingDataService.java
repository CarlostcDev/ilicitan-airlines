package com.ilicitan_airlines.backend.payment.service;

import com.ilicitan_airlines.backend.payment.repository.BillingDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingDataService {
    private final BillingDataRepository billingDataRepository;

    public BillingDataService(BillingDataRepository billingDataRepository) {
        this.billingDataRepository = billingDataRepository;
    }
}