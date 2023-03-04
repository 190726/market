package com.sk.market.product.repository;

import java.util.List;
import java.util.UUID;

import com.sk.market.product.domain.Product;

public interface ProductRepository {

	Product save(Product product);

	Product findBy(UUID id);

	List<Product> findAll();

}
