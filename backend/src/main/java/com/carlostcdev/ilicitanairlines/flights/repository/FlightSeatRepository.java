package com.carlostcdev.ilicitanairlines.flights.repository;

import com.carlostcdev.ilicitanairlines.flights.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;

interface FlightSeatRepository extends JpaRepository<FlightSeat, Long> {

}