package order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderItem> items = new ArrayList<>();
	private BigDecimal totalPrice = BigDecimal.ZERO;

	public void addItem(OrderItem item) {
		items.add(item);
		calculatePrice(item.totalPrice());
	}

	private void calculatePrice(BigDecimal totalPricePerItem) {
		totalPrice = totalPrice.add(totalPricePerItem);
	}

	public BigDecimal totalPrice() {
		return totalPrice;
	}
}