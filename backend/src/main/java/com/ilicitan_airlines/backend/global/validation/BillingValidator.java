package com.ilicitan_airlines.backend.global.validation;

import com.ilicitan_airlines.backend.global.exception.IlicitanAirlinesException;
import com.ilicitan_airlines.backend.payment.enums.BillingType;

public final class BillingValidator {
    public static void validateBilling(BillingType billingType, String firstName, String lastName, String companyName, String taxId) {
        if (billingType == BillingType.INDIVIDUAL && (firstName == null || lastName == null)) {
            throw new IlicitanAirlinesException("Individual billing requires first name and last name");
        }

        if (billingType == BillingType.COMPANY && (companyName == null || taxId == null)) {
            throw new IlicitanAirlinesException("Company billing requires company name and tax ID");
        }
    }
}
