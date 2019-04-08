package com.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
