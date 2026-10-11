package com.carlostcdev.ilicitanairlines.information.repository;

import com.carlostcdev.ilicitanairlines.information.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

interface CheckinRepository extends JpaRepository<Checkin, Long> {

}