package order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class OrderServiceTest {


	@Test
	void orderOneItem() throws Exception {
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
		//합계 검증
		BigDecimal totalPrice = order.totalPrice();
		assertThat(totalPrice.toPlainString()).isEqualTo("110");
	}
	
	
}
