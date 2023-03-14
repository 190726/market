package com.sk.market.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(value = AccessLevel.PRIVATE)
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
