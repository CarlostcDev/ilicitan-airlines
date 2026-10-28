package com.ilicitan_airlines.backend.information.repository;

import com.ilicitan_airlines.backend.information.entity.BaggageOption;
import com.ilicitan_airlines.backend.information.enums.BaggageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaggageOptionRepository extends JpaRepository<BaggageOption, Long> {
    List<BaggageOption> findAllByStatus(BaggageStatus status);
}