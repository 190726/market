package com.sk.market.product.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;

	public Product register(Product product) {
		return productRepository.save(product);
	}

}
