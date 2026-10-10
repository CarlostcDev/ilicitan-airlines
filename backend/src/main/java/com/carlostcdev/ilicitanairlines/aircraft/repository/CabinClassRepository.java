package com.carlostcdev.ilicitanairlines.aircraft.repository;

import com.carlostcdev.ilicitanairlines.aircraft.entity.CabinClass;
import org.springframework.data.jpa.repository.JpaRepository;

interface CabinClassRepository extends JpaRepository<CabinClass, Long> {

}