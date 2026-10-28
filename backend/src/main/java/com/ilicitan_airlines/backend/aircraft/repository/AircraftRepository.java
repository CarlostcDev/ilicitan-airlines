package com.ilicitan_airlines.backend.aircraft.repository;

import com.ilicitan_airlines.backend.aircraft.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}