package com.ilicitan_airlines.backend.payment.controller.user;

import com.ilicitan_airlines.backend.payment.service.BillingDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/billing-data")
@Tag(name = "Billing Data", description = "User billing details for bookings")
public class BillingDataController {
    private final BillingDataService billingDataService;
}