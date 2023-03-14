package com.sk.market.order.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sk.market.order.domain.Order;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {

	OrderEntity toEntity(Order order);
	
	@Mapping(target = "items", ignore = true)
	Order toDomain(OrderEntity orderEntity);
}
