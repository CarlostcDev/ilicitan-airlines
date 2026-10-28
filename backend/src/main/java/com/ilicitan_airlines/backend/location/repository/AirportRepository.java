package com.ilicitan_airlines.backend.location.repository;

import com.ilicitan_airlines.backend.location.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByIataCode(String iataCode);
}