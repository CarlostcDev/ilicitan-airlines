package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.BaggageOption;
import com.ilicitan_airlines.backend.information.enums.BaggageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaggageOptionRepository extends JpaRepository<BaggageOption, Long> {
    List<BaggageOption> findAllByStatus(BaggageStatus status);
}