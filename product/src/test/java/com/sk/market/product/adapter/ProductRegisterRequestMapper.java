package com.sk.market.product.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sk.market.product.domain.Product;

@Mapper(componentModel = "spring")
public interface ProductRegisterRequestMapper {

	@Mapping(target = "id", ignore = true)
	Product toDomain(ProductRegisterRequest request);

}
