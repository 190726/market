package com.sk.market.product.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.sk.market.product.domain.NoExistProductException;
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
		UUID uuid = UUID.randomUUID();
		product.id(uuid);
		ProductEntity save = productEntityJpaRepository.save(productEntityMapper.toEntity(product));
		return productEntityMapper.toDomain(save);
	}

	@Override
	public Product findBy(UUID id) {
		Optional<ProductEntity> find = productEntityJpaRepository.findById(id);
		ProductEntity findProductEntity = find.orElseThrow(() -> new NoExistProductException(id));
		return productEntityMapper.toDomain(findProductEntity);
	}

	@Override
	public List<Product> findAll() {
		List<ProductEntity> findAll = productEntityJpaRepository.findAll();
		return productEntityMapper.toDomainList(findAll);
	}
}