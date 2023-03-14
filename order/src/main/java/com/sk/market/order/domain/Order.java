package com.sk.market.order.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sk.market.order.adapter.OrderEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

	private Long orderId;
	private List<OrderItem> items = new ArrayList<>();
	private BigDecimal totalPrice = BigDecimal.ZERO;
	private OrderStatus orderStatus;

	public void addItem(OrderItem item) {
		items.add(item);
		calculatePrice(item.totalPrice());
		orderStatus = OrderStatus.ORDERED;
	}

	private void calculatePrice(BigDecimal totalPricePerItem) {
		totalPrice = totalPrice.add(totalPricePerItem);
	}

	public BigDecimal totalPrice() {
		return totalPrice;
	}

	public OrderStatus status() {
		return orderStatus;
	}

	public void orderId(Long id) {
		this.orderId = id;
	}
	
	public Long orderId() {
		return this.orderId;
	}

	public Order pay() {
		this.orderStatus = OrderStatus.PAYED;
		return this;
	}
}