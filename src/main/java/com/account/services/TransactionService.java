package com.account.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.account.Entity.Transaction;
@Repository
public interface TransactionService {

	public List<Transaction> findByAccount(Long id);
	public List<Transaction> findByClient(Long id);
}
