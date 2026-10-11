package com.carlostcdev.ilicitanairlines.location.repository;

import com.carlostcdev.ilicitanairlines.location.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}