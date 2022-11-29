package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crm.model.Client;

interface ClientDirectory extends JpaRepository<Client, Long> {

}
