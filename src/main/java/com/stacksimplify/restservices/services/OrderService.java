package com.stacksimplify.restservices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;

public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	//getOrderById
	public Optional<Order> getOrderById(long id) throws OrderNotFoundException {
		Optional<Order> order = orderRepository.findById(id);
		
		if(!order.isPresent()) {
			throw new OrderNotFoundException("Order Not Found in user Repository");
		}
		
		return order;
	}
	
}
