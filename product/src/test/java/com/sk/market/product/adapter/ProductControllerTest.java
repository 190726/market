package com.sk.market.product.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.sk.market.product.domain.Category;
import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	@Autowired
	private ProductController productController;
	
	@Test
	void productRegister() throws Exception {
		String name = "좋은상품";
		long price = 1000L;
		Category category = Category.ETC;
		ProductRegisterRequest request = new ProductRegisterRequest(name, price, category);
		Product result = productController.register(request);
		assertThat(result.getId()).isNotNull();
	}
}
