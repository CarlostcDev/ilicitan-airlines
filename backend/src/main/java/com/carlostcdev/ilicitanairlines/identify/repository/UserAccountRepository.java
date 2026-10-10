package com.carlostcdev.ilicitanairlines.identify.repository;

import com.carlostcdev.ilicitanairlines.identify.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}