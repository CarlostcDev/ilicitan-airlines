package com.carlostcdev.ilicitanairlines.payment.repository;

import com.carlostcdev.ilicitanairlines.payment.entity.BillingData;
import org.springframework.data.jpa.repository.JpaRepository;

interface BillingDataRepository extends JpaRepository<BillingData, Long> {

}