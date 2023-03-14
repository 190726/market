package com.sk.market.order.domain;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {

	Order save(Order order);
	
	public Optional<Order> findBy(Long id);
	
	public List<Order> findAll();

}
