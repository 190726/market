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

import com.sk.market.product.repository.ProductInmemoryRepository;
import com.sk.market.product.repository.ProductRepository;

public class ProductServiceTest {

	private ProductService productService;
	
	@BeforeEach
	void init() {
		ProductRepository productRepository = new ProductInmemoryRepository();
		productService = new ProductService(productRepository);
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
		Product product = Product
				.builder()
					.name("상품명")
					.price(BigDecimal.ONE)
					.category(Category.ELECTRIC)
				.build();
		return product;
	}
	
	private void manyProductsSaved() {
		Product product1 = Product.builder().name("상품명4").price(BigDecimal.ONE).category(Category.ELECTRIC).build();
		Product product2 = Product.builder().name("상품명6").price(BigDecimal.ONE).category(Category.ELECTRIC).build();
		Product product3 = Product.builder().name("상품명3").price(BigDecimal.ONE).category(Category.ELECTRIC).build();
		Product product4 = Product.builder().name("상품명1").price(BigDecimal.TEN).category(Category.FOOD).build();
		Product product5 = Product.builder().name("상품명5").price(BigDecimal.ONE).category(Category.ELECTRIC).build();
		Product product6 = Product.builder().name("상품명2").price(BigDecimal.ONE).category(Category.ELECTRIC).build();
		Product product7 = Product.builder().name("상품명7").price(BigDecimal.ONE).category(Category.ETC).build();
		Product product8 = Product.builder().name("상품명8").price(BigDecimal.TEN).category(Category.FOOD).build();
		productService.register(product1);
		productService.register(product2);
		productService.register(product3);
		productService.register(product4);
		productService.register(product5);
		productService.register(product6);
		productService.register(product7);
		productService.register(product8);
	}
}