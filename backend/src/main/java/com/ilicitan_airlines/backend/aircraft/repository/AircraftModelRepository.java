package com.ilicitan_airlines.backend.aircraft.repository;

import com.ilicitan_airlines.backend.aircraft.entity.AircraftModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftModelRepository extends JpaRepository<AircraftModel, Long> {

}