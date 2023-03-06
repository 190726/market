package com.sk.market.product.adapter;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductPersistencePort;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort{
	
	private final ProductEntityJpaRepository productEntityJpaRepository;
	private final ProductEntityMapper productEntityMapper;

	@Override
	public Product save(Product product) {
		ProductEntity save = productEntityJpaRepository.save(productEntityMapper.toEntity(product));
		return productEntityMapper.toDomain(save);
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