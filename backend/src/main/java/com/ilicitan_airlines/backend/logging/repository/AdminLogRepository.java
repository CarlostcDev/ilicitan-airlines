package com.ilicitan_airlines.backend.logging.repository;

import com.ilicitan_airlines.backend.logging.entity.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {

}