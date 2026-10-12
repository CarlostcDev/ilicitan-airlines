package com.ilicitan_airlines.backend.location.repository;

import com.ilicitan_airlines.backend.location.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}