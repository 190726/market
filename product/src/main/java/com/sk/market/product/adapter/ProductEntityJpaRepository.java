package com.sk.market.product.adapter;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityJpaRepository extends JpaRepository<ProductEntity, UUID>{

}
