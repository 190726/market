package com.sk.market.order.adapter;

import com.sk.market.order.domain.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sk.market.order.domain.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {

	OrderEntity toEntity(Order order);

	Order toDomain(OrderEntity orderEntity);

	List<Order> toOrders(List<OrderEntity> orderEntities);

	OrderItemEntity map(OrderItem value);

	List<OrderItemEntity> toOrderItemEntities (List<OrderItem> orderItems);

	OrderItem mapToDomain(OrderItemEntity orderItemEntity);

	List<OrderItem> toOrderItem(List<OrderItemEntity> orderItemEntities);
}
