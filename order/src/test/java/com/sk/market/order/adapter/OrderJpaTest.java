package com.sk.market.order.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sk.market.order.domain.Order;
import com.sk.market.order.domain.OrderStub;

@SpringBootTest
public class OrderJpaTest {
	
	@Autowired OrderPersistenceAdapter orderPersistenceAdapter;

	@Test
	void orderSaved() throws Exception {
		Order order = OrderStub.orderStubs();
		Order save = orderPersistenceAdapter.save(order);
		System.out.println(save);
	}

}
