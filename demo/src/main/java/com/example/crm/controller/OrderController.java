package com.example.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.model.Order;
import com.example.crm.service.OrderDirectory;

@RestController
@RequestMapping("api")
public class OrderController {

	@Autowired
	private OrderDirectory orderDirectory;

	@GetMapping("orders")
	public List<Order> getOrder() {
		return orderDirectory.getOrders();
	}

	@GetMapping("orders/{id}")
	public ResponseEntity<Order> getOrdersById(@PathVariable("id") Long id) {
		Optional<Order> optionalOrder = orderDirectory.getOrderById(id);
		if (optionalOrder.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalOrder.get());
		}
	}
	
	@PostMapping("orders")
	public Order postOrder(@RequestBody Order newOrder) {
		orderDirectory.addOrder(newOrder);
		return newOrder;
	}
	
	@DeleteMapping("orders/{id}")
	public void deleteOrder(@PathVariable("id") Long id) {
		orderDirectory.deleteOrder(id);
	}
	
	@PutMapping("orders/{id}")
	public  ResponseEntity<Order> updateOrder(@RequestBody Order varOrder,@PathVariable("id") Long id){
		if(id != varOrder.getId()) {
			return ResponseEntity.badRequest().build();
		}
		else {
			orderDirectory.updateOrder(varOrder, id);
			return ResponseEntity.ok().build();
		}
	}

}
