package com.sk.market.product.domain;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;

	public Product register(Product product) {
		return productRepository.save(product);
	}

	public Product findBy(UUID id) {
		Product product = productRepository.findBy(id);
		if(product==null) throw new NoExistProductException(id, "");
		return product;
		
	}

}
