package com.sk.market.product.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductJpaTest {
	
	@Autowired ProductEntityJpaRepository productEntityJpaRepository;

	@Test
	void testName() throws Exception {
		productEntityJpaRepository.findAll();
	}
}
