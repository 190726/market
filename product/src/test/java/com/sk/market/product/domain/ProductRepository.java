package com.sk.market.product.domain;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {

	Product save(Product product);

	Product findBy(UUID id);

	List<Product> findAll();

}
