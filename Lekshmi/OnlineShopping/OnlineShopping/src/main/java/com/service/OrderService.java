package com.service;

import java.util.List;

import com.model.Order;

public interface OrderService {
	public List<Order> getAllOrderDetails();
	public Order getOrderDetailsByID(long orderId);
	public Order createOrder(Order order);
	public Order updateOrderDetailsByID(Order order);
	public void deleteOrderDetailsByID(long orderId);
	public void deleteAllOrderDetails();
}
