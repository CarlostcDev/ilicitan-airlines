package com.ilicitan_airlines.backend.reservation.repository;

import com.ilicitan_airlines.backend.reservation.entity.ReservationFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationFlightRepository extends JpaRepository<ReservationFlight, Long> {

}