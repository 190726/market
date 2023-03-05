package com.sk.market.product.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductValidator {
	
	public Product validate(Product product) {
		Objects.requireNonNull(product, "product object have not null");
		isEmpty(product.getName(), "상품명이 없습니다. product Name : " + product.getName());
		moreThanZero(product.getPrice());
		return product;
	}
	
	public void isEmpty(String str, String errMessage) {
		if(str==null || str.isBlank()) throw new WrongFormatProductException(errMessage);
	}
	
	public void moreThanZero(BigDecimal number) {
		
		if(number == null || number.compareTo(BigDecimal.ZERO) <= 0) {
			throw new WrongFormatProductException("가격은 0이상이어야 합니다. input : " + number.toPlainString());
		}
	}
}