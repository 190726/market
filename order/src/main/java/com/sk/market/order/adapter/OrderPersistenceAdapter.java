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
		System.out.println(order);
		OrderEntity orderEntity = orderEntityMapper.toEntity(order);
		System.out.println(orderEntity);
		OrderEntity save = orderEntityRepository.save(orderEntity);
		return orderEntityMapper.toDomain(save);
	}

	@Override
	public Optional<Order> findBy(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Order> findAll() {
		throw new UnsupportedOperationException();
	}

}
