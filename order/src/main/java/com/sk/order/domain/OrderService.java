package com.sk.order.domain;

public class OrderService {
	
	private final OrderPersistencePort orderPersistencePort;
	
	public OrderService(OrderPersistencePort orderPersistencePort) {
		this.orderPersistencePort = orderPersistencePort;
	}

	public Order place(Order order) {
		return orderPersistencePort.save(order);
	}
}
