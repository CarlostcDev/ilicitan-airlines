package com.ilicitan_airlines.backend.aircraft.repository;

import com.ilicitan_airlines.backend.aircraft.entity.AircraftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftModelRepository extends JpaRepository<AircraftModel, Long> {

}