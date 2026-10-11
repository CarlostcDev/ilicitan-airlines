package com.carlostcdev.ilicitanairlines.flight.repository;

import com.carlostcdev.ilicitanairlines.flight.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightSeatRepository extends JpaRepository<FlightSeat, Long> {

}