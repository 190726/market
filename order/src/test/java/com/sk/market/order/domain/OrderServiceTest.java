package com.sk.market.order.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.sk.market.order.adapter.OrderInmemoryAdapter;

public class OrderServiceTest {

	private OrderPersistencePort orderPersistencePort = new OrderInmemoryAdapter();
	private OrderService orderService = new OrderService(orderPersistencePort);

	@Test
	void orderOneItem() throws Exception {
		Order order = OrderStub.orderStubs();
		//합계 검증
		BigDecimal totalPrice = order.totalPrice();
		assertThat(totalPrice.toPlainString()).isEqualTo("110");
		assertThat(order.status().name()).isEqualTo("ORDERED");
	}
	
	@Test
	void orderPlaceTest() throws Exception {
		Order place = orderService.place(OrderStub.orderStubs());
		assertThat(place.orderId()).isEqualTo(1L);
	}
	
	@Test
	void orderPayTest() throws Exception {
		Order order = orderService.place(OrderStub.orderStubs());
		Order payedOrder = orderService.pay(order.orderId());
		assertThat(payedOrder.status()).isEqualTo(OrderStatus.PAYED);
	}
}