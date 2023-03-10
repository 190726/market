package com.sk.market.product.web;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	private final ProductRegisterRequestMapper productRegisterRequestMapper;

	@PostMapping("/product")
	public ResponseEntity<Void> register(@RequestBody ProductRegisterRequest request) {
		Product product = productRegisterRequestMapper.toDomain(request);
		productService.register(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/product")
	public ProductResponse findBy(@RequestParam("productId") String productId) {
		Product findProduct = productService.findBy(UUID.fromString(productId));
		return new ProductResponse(findProduct.getId().toString()
				, findProduct.getName(), findProduct.getPrice().toPlainString());
	}
}