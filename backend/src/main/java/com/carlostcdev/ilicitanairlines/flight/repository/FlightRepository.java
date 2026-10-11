package com.carlostcdev.ilicitanairlines.flight.repository;

import com.carlostcdev.ilicitanairlines.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}