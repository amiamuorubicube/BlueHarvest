package com.account.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.account.Entity.Account;

@Repository
public class AccountServiceImpl implements AccountService {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Account> findByClient(Long id) {
		return jdbcTemplate.query("select * from Account_TABLE where client=?", new Object[] {id},
		        new BeanPropertyRowMapper (Account.class));
	}

}
