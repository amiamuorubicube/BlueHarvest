package com.account.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.account.Entity.Account;

@Repository
public interface AccountService {

	public List<Account> findByClient(Long id);
}
