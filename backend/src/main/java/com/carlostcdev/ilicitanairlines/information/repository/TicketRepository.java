package com.carlostcdev.ilicitanairlines.information.repository;

import com.carlostcdev.ilicitanairlines.information.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

interface TicketRepository extends JpaRepository<Ticket, Long> {

}