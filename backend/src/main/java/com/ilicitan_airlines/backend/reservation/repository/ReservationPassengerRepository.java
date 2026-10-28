package com.ilicitan_airlines.backend.reservation.repository;

import com.ilicitan_airlines.backend.reservation.entity.ReservationPassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationPassengerRepository extends JpaRepository<ReservationPassenger, Long> {

}