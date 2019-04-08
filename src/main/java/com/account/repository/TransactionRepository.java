package com.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
