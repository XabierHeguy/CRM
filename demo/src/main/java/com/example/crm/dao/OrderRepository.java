package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
