package com.ilicitan_airlines.backend.logging.repository;

import com.ilicitan_airlines.backend.logging.entity.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {

}