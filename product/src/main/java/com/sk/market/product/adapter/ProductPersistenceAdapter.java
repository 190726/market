package com.sk.market.product.adapter;

import java.util.List;
import java.util.UUID;

import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductRepository{
	
	private final ProductEntityJpaRepository productEntityJpaRepository;

	@Override
	public Product save(Product product) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product findBy(UUID id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Product> findAll() {
		throw new UnsupportedOperationException();
	}
}