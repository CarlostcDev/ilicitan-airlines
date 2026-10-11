package com.carlostcdev.ilicitanairlines.reservation.repository;

import com.carlostcdev.ilicitanairlines.reservation.entity.ReservationPassenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationPassengerRepository extends JpaRepository<ReservationPassenger, Long> {

}