package com.sk.market.product.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

	private ProductService productService;
	
	@BeforeEach
	void init() {
		ProductRepository productRepository = new ProductInmemoryRepository();
		productService = new ProductService(productRepository);
	}

	@Test
	void registerProduct() throws Exception {
		Product product = Product
				.builder()
					.name("상품명")
					.price(BigDecimal.ONE)
					.category(Category.ELECTRIC)
				.build();
		Product register = productService.register(product);
		assertThat(register.getName()).isEqualTo(product.getName());
	}
	
}