package com.ilicitan_airlines.backend.identify.repository;

import com.ilicitan_airlines.backend.identify.entity.AuthAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthAccountRepository extends JpaRepository<AuthAccount, Long> {

}