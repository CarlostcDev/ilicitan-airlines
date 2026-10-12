package com.ilicitan_airlines.backend.flight.repository;

import com.ilicitan_airlines.backend.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("""
            SELECT f FROM Flight f
            WHERE f.origin.iataCode = :originIata
            AND f.destination.iataCode = :destinationIata
            AND f.scheduledDepartureUtc >= :startUtc
            AND f.scheduledDepartureUtc < :endUtc
            AND f.status = FlightStatus.SCHEDULED
            ORDER BY f.scheduledDepartureUtc
            """)
    List<Flight> searchFlights(
            @Param("originIata") String originIata,
            @Param("destinationIata") String destinationIata,
            @Param("startUtc") LocalDateTime startUtc,
            @Param("endUtc") LocalDateTime endUtc
    );
}