package com.sk.market.product.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

	private ProductService productService;
	
	@BeforeEach
	void init() {
		productService = new ProductService();
	}

	@Test
	void registerProduct() throws Exception {
		Product product = Product
				.builder()
					.id(UUID.randomUUID())
					.name("상품명")
					.price(BigDecimal.ONE)
					.category(Category.ELECTRIC)
				.build();
		productService.register(product);
	}
}
