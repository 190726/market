package com.sk.market.product.domain;

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
public class Product {
	private UUID id;
	private String name;
	private BigDecimal price;
	private Category category;
}
