package com.sk.market.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderStub {
	
	public static Order orderStubs() {
		/**
		 * 상품명 / 10개 / 10원
		 * 상품명2 / 1개 / 10원
		 */
		Order order = new Order();
		//아이템1 생성
		OrderItem item1 = OrderItem.builder()
				.productId(UUID.randomUUID())
				.productNm("상품명")
				.amount(10L)
				.price(BigDecimal.TEN)
				.build();
		OrderItem item2 = OrderItem.builder()
				.productId(UUID.randomUUID())
				.productNm("상품명2")
				.amount(1L)
				.price(BigDecimal.TEN)
				.build();
		order.addItem(item1);
		order.addItem(item2);
		return order;
	}

}
