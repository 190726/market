package com.sk.order.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sk.order.domain.Order;
import com.sk.order.domain.OrderPersistencePort;

public class OrderInmemoryAdapter implements OrderPersistencePort {
	
	private final Map<Long, Order> persistenceMap = new HashMap<>();
	private Long seq = 0L;

	@Override
	public Order save(Order order) {
		order.orderId(++seq);
		persistenceMap.put(seq, order);
		return order;
	}
	
	public Optional<Order> findBy(Long id) {
		return Optional.of(persistenceMap.get(id));
	}
	
	public List<Order> findAll(){
		return new ArrayList<>(persistenceMap.values());
	}
}