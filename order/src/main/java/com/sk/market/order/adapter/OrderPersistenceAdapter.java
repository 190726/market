package com.sk.market.order.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sk.market.order.domain.Order;
import com.sk.market.order.domain.OrderPersistencePort;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort{

	private final OrderEntityRepository orderEntityRepository;
	private final OrderEntityMapper orderEntityMapper;

	@Override
	public Order save(Order order) {
		OrderEntity save = orderEntityRepository.save(
				orderEntityMapper.toEntity(order)
		);
		return orderEntityMapper.toDomain(save);
	}

	@Override
	public Optional<Order> findBy(Long id) {
		return Optional.of(
				orderEntityMapper.toDomain(orderEntityRepository.findById(id).get())
		);
	}

	@Override
	public List<Order> findAll() {
		return orderEntityMapper.toOrders(orderEntityRepository.findAll());
	}
}
