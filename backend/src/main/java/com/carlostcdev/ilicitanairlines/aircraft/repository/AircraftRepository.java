package com.carlostcdev.ilicitanairlines.aircraft.repository;

import com.carlostcdev.ilicitanairlines.aircraft.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}