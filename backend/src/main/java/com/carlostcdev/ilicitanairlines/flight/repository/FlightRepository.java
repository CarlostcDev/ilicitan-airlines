package com.carlostcdev.ilicitanairlines.flight.repository;

import com.carlostcdev.ilicitanairlines.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

interface FlightRepository extends JpaRepository<Flight, Long> {

}