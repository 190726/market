package order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.sk.order.domain.Order;
import com.sk.order.domain.OrderItem;
import com.sk.order.domain.OrderPersistencePort;
import com.sk.order.domain.OrderService;

public class OrderServiceTest {

	private OrderPersistencePort orderPersistencePort = new OrderInmemoryAdapter();
	private OrderService orderService = new OrderService(orderPersistencePort);

	@Test
	void orderOneItem() throws Exception {
		Order order = orderStubs();
		//합계 검증
		BigDecimal totalPrice = order.totalPrice();
		assertThat(totalPrice.toPlainString()).isEqualTo("110");
		assertThat(order.status().name()).isEqualTo("ORDERED");
	}
	
	@Test
	void orderPlaceTest() throws Exception {
		Order place = orderService.place(orderStubs());
		assertThat(place.orderId()).isEqualTo(1L);
	}
	
	private Order orderStubs() {
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
