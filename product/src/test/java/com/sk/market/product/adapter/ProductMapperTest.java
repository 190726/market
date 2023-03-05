package com.sk.market.product.adapter;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sk.market.product.domain.Category;
import com.sk.market.product.domain.Product;

@SpringBootTest
public class ProductMapperTest {
	
	@Autowired ProductEntityMapper mapper;
	
	@Test
	void mappingTest() throws Exception {
		Product product = productStub();
		ProductEntity entity = mapper.toEntity(product);
		System.out.println(entity);
		
	}
	
	private Product productStub() {
		Product product = Product
				.builder()
					.name("상품명")
					.price(BigDecimal.ONE)
					.category(Category.ELECTRIC)
				.build();
		return product;
	}

}
