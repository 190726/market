package order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class Order {

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
}