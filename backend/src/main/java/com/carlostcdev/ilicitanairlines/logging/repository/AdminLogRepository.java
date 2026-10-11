package com.carlostcdev.ilicitanairlines.logging.repository;

import com.carlostcdev.ilicitanairlines.logging.entity.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

interface AdminLogRepository extends JpaRepository<AdminLog, Long> {

}