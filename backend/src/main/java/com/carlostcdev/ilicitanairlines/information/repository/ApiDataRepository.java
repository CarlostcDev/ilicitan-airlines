package com.carlostcdev.ilicitanairlines.information.repository;

import com.carlostcdev.ilicitanairlines.information.entity.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;

interface ApiDataRepository extends JpaRepository<ApiData, Long> {

}