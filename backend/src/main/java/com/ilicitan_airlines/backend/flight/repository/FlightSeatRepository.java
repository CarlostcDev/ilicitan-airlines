package com.ilicitan_airlines.backend.flight.repository;

import com.ilicitan_airlines.backend.flight.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat, Long> {

}