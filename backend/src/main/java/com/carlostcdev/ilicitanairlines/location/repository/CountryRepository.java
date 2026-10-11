package com.carlostcdev.ilicitanairlines.location.repository;

import com.carlostcdev.ilicitanairlines.location.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}