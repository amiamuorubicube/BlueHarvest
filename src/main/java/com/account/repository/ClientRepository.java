package com.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
