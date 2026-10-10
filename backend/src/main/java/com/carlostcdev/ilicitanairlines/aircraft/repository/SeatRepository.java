package com.carlostcdev.ilicitanairlines.aircraft.repository;

import com.carlostcdev.ilicitanairlines.aircraft.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

interface SeatRepository extends JpaRepository<Seat, Long> {

}