package com.sk.market.product.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.sk.market.product.ProductStub;
import com.sk.market.product.domain.Product;

@SpringBootTest
public class ProductJpaTest {
	
	@Autowired ProductPersistenceAdapter persistenceAdapter;

	@Test
	void 저장후조회하기() throws Exception {
		Product product = ProductStub.product();
		Product save = persistenceAdapter.save(product);
		assertThat(save.getName()).isEqualTo(product.getName());
		Product findProduct = persistenceAdapter.findBy(save.getId());
		assertThat(findProduct.getId()).isEqualTo(save.getId());
	}
}
