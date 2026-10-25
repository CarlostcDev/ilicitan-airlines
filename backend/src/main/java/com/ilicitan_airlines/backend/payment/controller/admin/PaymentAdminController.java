package com.ilicitan_airlines.backend.payment.controller.admin;

import com.ilicitan_airlines.backend.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/payments")
@Tag(name = "Payments", description = "Management of reservation payments for administrators")
public class PaymentAdminController {
    private final PaymentService paymentService;
}