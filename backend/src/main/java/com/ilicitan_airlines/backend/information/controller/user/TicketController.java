package com.ilicitan_airlines.backend.information.controller.user;

import com.ilicitan_airlines.backend.information.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
@Tag(name = "ticket", description = "Booking management per passenger")
public class TicketController {
    private final TicketService ticketService;
}
