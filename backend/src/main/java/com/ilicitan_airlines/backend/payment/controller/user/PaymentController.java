package com.ilicitan_airlines.backend.payment.controller.user;

import com.ilicitan_airlines.backend.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
@Tag(name = "Payments", description = "User payments for bookings")
public class PaymentController {
    private final PaymentService paymentService;
}