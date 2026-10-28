package com.ilicitan_airlines.backend.identify.repository;

import com.ilicitan_airlines.backend.identify.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}