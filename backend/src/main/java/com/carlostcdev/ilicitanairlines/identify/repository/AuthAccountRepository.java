package com.carlostcdev.ilicitanairlines.identify.repository;

import com.carlostcdev.ilicitanairlines.identify.entity.AuthAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthAccountRepository extends JpaRepository<AuthAccount, Long> {

}