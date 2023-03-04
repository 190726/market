package com.sk.market.product.domain;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductValidation productValidation = new ProductValidation();

	public Product register(Product product) {
		return productRepository.save(productValidation.validate(product));
	}

	public Product findBy(UUID id) {
		Product product = productRepository.findBy(id);
		if(product==null) throw new NoExistProductException(id, "");
		return product;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}