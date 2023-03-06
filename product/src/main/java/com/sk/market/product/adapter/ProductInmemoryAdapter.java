package com.sk.market.product.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.sk.market.product.domain.Product;
import com.sk.market.product.domain.ProductPersistencePort;

public class ProductInmemoryAdapter implements ProductPersistencePort {
	
	private final static Map<UUID, Product> persistenceMap = new HashMap<>();

	@Override
	public Product save(Product product) {
		UUID uuid = UUID.randomUUID();
		product.id(uuid);
		persistenceMap.putIfAbsent(uuid, product);
		return persistenceMap.get(uuid);
	}

	@Override
	public Product findBy(UUID id) {
		return persistenceMap.get(id);
	}

	@Override
	public List<Product> findAll() {
		return new ArrayList<>(persistenceMap.values());
	}
}