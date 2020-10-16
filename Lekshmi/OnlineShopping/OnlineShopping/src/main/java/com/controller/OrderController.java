package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Order;
import com.service.OrderService;

@RestController("/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getAllOrderDetails")
	public ResponseEntity<List<Order>> getAllOrderDetails(){
		System.out.println("getAll");
		return ResponseEntity.ok().body(orderService.getAllOrderDetails());
	}
	
	@GetMapping("/getOrderDetailsByID/{orderId}")
	public ResponseEntity<Order> getOrderDetailsByID(@PathVariable long orderId){
		return ResponseEntity.ok().body(orderService.getOrderDetailsByID(orderId));
	}
	
	@PostMapping("/CreateOrder")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		return ResponseEntity.ok().body(this.orderService.createOrder(order));
	}
	
	@PutMapping("/updateOrderDetailsByID/{orderId}")
	public ResponseEntity<Order> updateOrderDetailsByID(@PathVariable long orderId, @RequestBody Order order){
		order.setOrderId(orderId);
		return ResponseEntity.ok().body(this.orderService.updateOrderDetailsByID(order));
	}

	@DeleteMapping("/deleteOrderDetailsByID/{id}")
	public HttpStatus deleteOrderDetailsByID(@PathVariable long orderId){
		this.orderService.deleteOrderDetailsByID(orderId);
		return HttpStatus.OK;
	}
	
	@DeleteMapping("/deleteAllOrderDetails")
	public HttpStatus deleteAllOrderDetails(){
		this.orderService.deleteAllOrderDetails();
		return HttpStatus.OK;
	}
}
