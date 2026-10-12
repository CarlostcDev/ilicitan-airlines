package com.ilicitan_airlines.backend.reservation.repository;

import com.ilicitan_airlines.backend.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}