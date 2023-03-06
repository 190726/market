package com.sk.market.product.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.market.product.ProductStub;
import com.sk.market.product.adapter.ProductInmemoryAdapter;

public class ProductServiceTest {

	private ProductService productService;
	
	@BeforeEach
	void init() {
		ProductPersistencePort productPersistencePort = new ProductInmemoryAdapter();
		productService = new ProductService(productPersistencePort);
	}

	@Test
	void registerProduct() throws Exception {
		Product product = productStub();
		Product register = productService.register(product);
		assertThat(register.getName()).isEqualTo(product.getName());
	}
	
	@Test
	void findProduct() throws Exception {
		Product product = productStub();
		Product register = productService.register(product);
		Product find = productService.findBy(register.getId());
		assertThat(find.getName()).isEqualTo(product.getName());
	}
	
	@Test
	void _존재하지않는_상품조회시() throws Exception {
		Assertions.assertThrows(NoExistProductException.class,
				() -> productService.findBy(UUID.randomUUID()));
	}
	
	@Test
	void _전체상품조회시() throws Exception {
		manyProductsSaved();
		List<Product> findAll = productService.findAll();
		assertTrue(findAll.size() > 0, "상품목록이 존재하지 않습니다.");
	}
	
	@Test
	void _잘못된상품유효성체크() throws Exception {
		ProductValidator validation = new ProductValidator();
		assertThrows(WrongFormatProductException.class, ()->validation.validate(productErrStub()));
	}

	private Product productErrStub() {
		Product product = Product
				.builder()
					.name("상품명")
					.price(BigDecimal.ZERO)
					.category(Category.ELECTRIC)
				.build();
		return product;
	}

	private Product productStub() {
		return ProductStub.product();
	}
	
	private void manyProductsSaved() {
		ProductStub.products().forEach(p -> productService.register(p));
	}
}