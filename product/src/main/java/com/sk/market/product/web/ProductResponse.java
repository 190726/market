package com.sk.market.product.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
	
	private String id;
	private String name;
	private String price;

}
