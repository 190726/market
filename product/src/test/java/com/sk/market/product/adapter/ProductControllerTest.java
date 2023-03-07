package com.sk.market.product.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.market.product.domain.Category;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	private ProductController productController;
	
	@BeforeEach
	void init() {
		productController = new ProductController();
	}

	@Test
	void productRegister() throws Exception {
		String name = "좋은상품";
		long price = 1000L;
		Category category = Category.ETC;
		ProductRegisterRequest request = new ProductRegisterRequest(name, price, category);
		String result = productController.register(request);
		assertThat(result).isEqualTo("success");
	}
}
