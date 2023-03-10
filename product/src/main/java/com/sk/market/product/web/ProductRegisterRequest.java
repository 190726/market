package com.sk.market.product.web;

import com.sk.market.product.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterRequest {

	private String name;
	private long price;
	private Category category;
}
