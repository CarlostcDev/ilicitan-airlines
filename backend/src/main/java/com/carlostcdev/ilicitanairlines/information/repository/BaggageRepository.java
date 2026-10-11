package com.carlostcdev.ilicitanairlines.information.repository;

import com.carlostcdev.ilicitanairlines.information.entity.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

interface BaggageRepository extends JpaRepository<Baggage, Long> {

}