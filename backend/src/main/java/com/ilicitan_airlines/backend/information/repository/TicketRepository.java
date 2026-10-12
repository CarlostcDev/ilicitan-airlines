package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}