package com.carlostcdev.ilicitanairlines.reservation.repository;

import com.carlostcdev.ilicitanairlines.reservation.entity.ReservationFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationFlightRepository extends JpaRepository<ReservationFlight, Long> {

}