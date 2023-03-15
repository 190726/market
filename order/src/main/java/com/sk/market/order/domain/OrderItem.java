package com.sk.market.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.*;

@Data
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderItem {
	
	private Long id;
	private UUID productId;
	private String productNm;
	private Long amount;
	private BigDecimal price;
	
	public BigDecimal totalPrice() {
		return price.multiply(BigDecimal.valueOf(amount));
	}

}
