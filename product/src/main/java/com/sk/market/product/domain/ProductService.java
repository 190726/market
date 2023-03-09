package com.sk.market.product.domain;

import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductPersistencePort productRepository;
	private final ProductValidator productValidator = new ProductValidator();

	public Product register(Product product) {
		return productRepository.save(
				product.validate(productValidator));
	}

	public Product findBy(UUID id) {
		Product product = productRepository.findBy(id);
		if(product==null) throw new NoExistProductException(id, "");
		return product;
	}

	public List<Product> findAll() {
		return productRepository.findAll().stream()
				.sorted(Comparator.comparing(Product::getName)).toList() ;
	}

	public Map<Category, List<Product>> groupByCategory() {
		return findAll()
				.stream()
				.collect(groupingBy(Product::getCategory));
	}
}