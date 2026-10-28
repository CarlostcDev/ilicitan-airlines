package com.ilicitan_airlines.backend.reservation.repository;

import com.ilicitan_airlines.backend.reservation.entity.ReservationPassenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationPassengerRepository extends JpaRepository<ReservationPassenger, Long> {

}