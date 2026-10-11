package com.carlostcdev.ilicitanairlines.flight.repository;

import com.carlostcdev.ilicitanairlines.flight.entity.FlightFare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightFareRepository extends JpaRepository<FlightFare, Long> {

}