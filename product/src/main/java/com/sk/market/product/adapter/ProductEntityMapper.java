package com.sk.market.product.adapter;

import org.mapstruct.Mapper;

import com.sk.market.product.domain.Product;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
	
	ProductEntity toEntity(Product product);
	
	Product toDomain(ProductEntity productEntity);
}
