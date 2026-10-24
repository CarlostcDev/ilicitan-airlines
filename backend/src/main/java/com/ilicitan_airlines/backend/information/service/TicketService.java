package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
}