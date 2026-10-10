package com.carlostcdev.ilicitanairlines.reservation.repository;

import com.carlostcdev.ilicitanairlines.reservation.entity.ReservationFlight;
import org.springframework.data.jpa.repository.JpaRepository;

interface ReservationFlightRepository extends JpaRepository<ReservationFlight, Long> {

}