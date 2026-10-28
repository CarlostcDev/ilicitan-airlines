package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiDataRepository extends JpaRepository<ApiData, Long> {

}