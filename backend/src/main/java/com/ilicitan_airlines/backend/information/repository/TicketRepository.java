package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}