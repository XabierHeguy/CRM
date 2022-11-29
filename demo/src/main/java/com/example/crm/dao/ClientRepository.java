package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crm.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
