package com.ilicitan_airlines.backend.payment.controller.admin;

import com.ilicitan_airlines.backend.payment.service.BillingDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/billing-data")
@Tag(name = "Billing Data", description = "Management of user billing data for administrators")
public class BillingDataAdminController {
    private final BillingDataService billingDataService;
}