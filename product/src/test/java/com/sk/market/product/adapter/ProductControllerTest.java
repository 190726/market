package com.sk.market.product.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.sk.market.product.ProductStub;
import com.sk.market.product.domain.Category;
import com.sk.market.product.domain.Product;
import com.sk.market.product.web.ProductRegisterRequest;
import com.sk.market.product.web.ProductResponse;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired ProductPersistenceAdapter persistenceAdapter;

	@BeforeEach
	void init() {
		RestAssured.port = port;
	}
	
	@Test
	void productRegister() throws Exception {
		ProductRegisterRequest request = productRegisterStub();
		
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.body(request)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.post("/product")
				.then().log().all().extract();
		
		assertThat(response.statusCode()).isEqualTo(org.springframework.http.HttpStatus.CREATED.value());
		
	}
	
	@Test
	void notValidatedProductRegister() throws Exception {
		ProductRegisterRequest request = notValidatedOroductRegisterStub();
		
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.body(request)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.post("/product")
				.then().log().all().extract();
		assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	void findProductById() throws Exception {
		//given 상품 1개 저장
		Product product = ProductStub.product();
		Product save = persistenceAdapter.save(product);
		//when 상품 조회
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.queryParam("productId", save.getId().toString())
				.when()
				.get("/product")
				.then().log().all().extract();
		assertThat(response.as(ProductResponse.class).getId()).isEqualTo(save.getId().toString());
	}
	
	@Test
	void noExistProductFindById() throws Exception {
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.queryParam("productId", UUID.randomUUID().toString())
				.when()
				.get("/product")
				.then().log().all().extract();
		assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

	private ProductRegisterRequest productRegisterStub() {
		String name = "상품명";
		long price = 1000L;
		Category category = Category.ETC;
		ProductRegisterRequest request = new ProductRegisterRequest(name, price, category);
		return request;
	}
	
	private ProductRegisterRequest notValidatedOroductRegisterStub() {
		String name = "";
		long price = 1000L;
		Category category = Category.ETC;
		ProductRegisterRequest request = new ProductRegisterRequest(name, price, category);
		return request;
	}
	
}
