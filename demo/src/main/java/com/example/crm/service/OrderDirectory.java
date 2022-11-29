package com.example.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crm.dao.OrderRepository;
import com.example.crm.model.Order;

@Service
public class OrderDirectory {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public void addOrder(Order order) {
		orderRepository.save(order);
	}
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	public Optional<Order> getOrderById(Long id){
		return orderRepository.findById(id);
	}
	
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
	
	public void updateOrder(Order order, Long id) {
		orderRepository.save(order);
	}

}
