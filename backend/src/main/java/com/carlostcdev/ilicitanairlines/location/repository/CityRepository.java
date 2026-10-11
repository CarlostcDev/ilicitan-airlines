package com.carlostcdev.ilicitanairlines.location.repository;

import com.carlostcdev.ilicitanairlines.location.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}