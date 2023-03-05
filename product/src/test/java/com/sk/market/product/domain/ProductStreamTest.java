package com.sk.market.product.domain;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.comparator.Comparators;

import com.sk.market.product.repository.ProductInmemoryRepository;
import com.sk.market.product.repository.ProductRepository;

public class ProductStreamTest {
	
private ProductService productService;
	
	@BeforeEach
	void init() {
		ProductRepository productRepository = new ProductInmemoryRepository();
		productService = new ProductService(productRepository);
		Product product1 = Product.builder().name("상품명4").price(new BigDecimal(150)).category(Category.ELECTRIC).build();
		Product product2 = Product.builder().name("상품명6").price(new BigDecimal(110)).category(Category.ELECTRIC).build();
		Product product3 = Product.builder().name("상품명3").price(new BigDecimal(120)).category(Category.ELECTRIC).build();
		Product product4 = Product.builder().name("상품명1").price(BigDecimal.TEN).category(Category.FOOD).build();
		Product product5 = Product.builder().name("상품명5").price(new BigDecimal(190)).category(Category.ELECTRIC).build();
		Product product6 = Product.builder().name("상품명2").price(new BigDecimal(250)).category(Category.ELECTRIC).build();
		Product product7 = Product.builder().name("상품명7").price(new BigDecimal(50)).category(Category.ETC).build();
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
	
	@Test
	void productSortTest() throws Exception {
		
		Comparator<Product> compare = (p1, p2) -> p1.getCategory().compareTo(p2.getCategory());
		Comparator<Product> compare2 = Comparator.comparing((Product p) -> p.getCategory());
		Comparator<Product> compare3 = Comparator.comparing(Product::getCategory);
		
		
		//카테고리순 -> 가격순
		productService.findAll()
				.stream()
				.sorted(compare3
						.thenComparing(comparing(Product::getPrice).reversed()))
				.toList()
				.forEach(System.out::println);;
		
	}
}