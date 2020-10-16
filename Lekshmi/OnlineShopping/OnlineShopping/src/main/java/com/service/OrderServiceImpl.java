package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exception.ResourceNotFoundException;
import com.model.Order;
import com.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{


	@Autowired
	private OrderRepository orderRepository;


	@Override
	public List<Order> getAllOrderDetails() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order getOrderDetailsByID(long orderId) {

		Optional<Order> orderID = this.orderRepository.findById(orderId);

		if(orderID.isPresent()) {
			return orderID.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + orderId);
		}
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrderDetailsByID(Order order) {
		Optional<Order> orderID = this.orderRepository.findById(order.getOrderId());

		if(orderID.isPresent()) {
			Order orderUpdate = orderID.get();
			orderUpdate.setOrderId(order.getOrderId());
			orderUpdate.setType(order.getType());
			orderUpdate.setOrderedQuantity(order.getOrderedQuantity());
			/*
			 * add requried attributes to update
			 */
			orderRepository.save(orderUpdate);
			return orderUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + order.getOrderId());
		}		
	}

	@Override
	public void deleteOrderDetailsByID(long orderId) {
		Optional<Order> orderID = this.orderRepository.findById(orderId);

		if(orderID.isPresent()) {
			this.orderRepository.delete(orderID.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + orderID);
		}

	}

	@Override
	public void deleteAllOrderDetails() {
		this.orderRepository.deleteAll();	
	}

}
