package com.carlostcdev.ilicitanairlines.flights.repository;

import com.carlostcdev.ilicitanairlines.flights.entity.FlightFare;
import org.springframework.data.jpa.repository.JpaRepository;

interface FlightFareRepository extends JpaRepository<FlightFare, Long> {

}