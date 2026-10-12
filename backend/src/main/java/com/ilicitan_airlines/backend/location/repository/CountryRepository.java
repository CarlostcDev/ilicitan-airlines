package com.ilicitan_airlines.backend.location.repository;

import com.ilicitan_airlines.backend.location.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}