package com.carlostcdev.ilicitanairlines.reservation.repository;

import com.carlostcdev.ilicitanairlines.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}