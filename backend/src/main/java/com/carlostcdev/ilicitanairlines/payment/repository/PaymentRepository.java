package com.carlostcdev.ilicitanairlines.payment.repository;

import com.carlostcdev.ilicitanairlines.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {

}