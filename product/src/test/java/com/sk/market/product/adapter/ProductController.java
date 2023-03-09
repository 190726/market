package com.sk.market.product.adapter;

import org.springframework.web.bind.annotation.RestController;

import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	private final ProductRegisterRequestMapper productRegisterRequestMapper;

	public Product register(ProductRegisterRequest request) {
		Product product = productRegisterRequestMapper.toDomain(request);
		return productService.register(product);
	}

}
