package com.ilicitan_airlines.backend.flight.repository;

import com.ilicitan_airlines.backend.flight.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightSeatRepository extends JpaRepository<FlightSeat, Long> {

}