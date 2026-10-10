package com.carlostcdev.ilicitanairlines.flights.repository;

import com.carlostcdev.ilicitanairlines.flights.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

interface FlightRepository extends JpaRepository<Flight, Long> {

}