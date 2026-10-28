package com.ilicitan_airlines.backend.payment.repository;

import com.ilicitan_airlines.backend.payment.entity.BillingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingDataRepository extends JpaRepository<BillingData, Long> {

}