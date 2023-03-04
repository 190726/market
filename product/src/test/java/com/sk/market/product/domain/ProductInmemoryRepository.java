package com.sk.market.product.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductInmemoryRepository implements ProductRepository {
	
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
}