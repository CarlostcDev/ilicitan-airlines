package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {

}