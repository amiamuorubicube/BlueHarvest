package com.account.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.account.Entity.Transaction;

@Repository
public class TransactionServiceImpl implements TransactionService {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Transaction> findByAccount(Long id) {
		
		return jdbcTemplate.query("select * from Transaction_TABLE where account=?", new Object[] {id},
	        new BeanPropertyRowMapper (Transaction.class));
		
	}

	@Override
	public List<Transaction> findByClient(Long id) {
		return jdbcTemplate.query("select * from Transaction_TABLE where client=? order by account", new Object[] {id},
		        new BeanPropertyRowMapper (Transaction.class));
	}

}
