package com.sk.order.domain;

import java.util.Optional;

public class OrderService {
	
	private final OrderPersistencePort orderPersistencePort;
	
	public OrderService(OrderPersistencePort orderPersistencePort) {
		this.orderPersistencePort = orderPersistencePort;
	}

	public Order place(Order order) {
		return orderPersistencePort.save(order);
	}

	public Order pay(Long orderId) {
		Order order = orderPersistencePort.findBy(orderId)
						.orElseThrow(NotExistOrderException::new);
		return order.pay();
	}
}
