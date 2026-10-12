package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiDataRepository extends JpaRepository<ApiData, Long> {

}