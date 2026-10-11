package com.carlostcdev.ilicitanairlines.information.repository;

import com.carlostcdev.ilicitanairlines.information.entity.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardingPassRepository extends JpaRepository<BoardingPass, Long> {

}