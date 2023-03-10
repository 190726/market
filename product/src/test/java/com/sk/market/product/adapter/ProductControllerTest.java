package com.sk.market.product.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import com.sk.market.product.domain.Category;
import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductService;
import com.sk.market.product.web.ProductRegisterRequest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
	
	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		RestAssured.port = port;
	}
	
	@Test
	void productRegister() throws Exception {
		String name = "좋은상품";
		long price = 1000L;
		Category category = Category.ETC;
		ProductRegisterRequest request = new ProductRegisterRequest(name, price, category);
		
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.body(request)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.post("/product")
				.then().log().all().extract();
		
		assertThat(response.statusCode()).isEqualTo(org.springframework.http.HttpStatus.CREATED.value());
		
	}
}
