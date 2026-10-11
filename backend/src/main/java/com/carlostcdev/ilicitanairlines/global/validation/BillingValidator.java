package com.carlostcdev.ilicitanairlines.global.validation;

import com.carlostcdev.ilicitanairlines.global.exception.IlicitanAirlinesException;
import com.carlostcdev.ilicitanairlines.payment.enums.BillingType;

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
