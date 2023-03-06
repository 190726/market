package com.sk.market.product;

import java.math.BigDecimal;
import java.util.List;

import com.sk.market.product.domain.Category;
import com.sk.market.product.domain.Product;

public class ProductStub {
	
	public static List<Product> products(){
		return List.of(
				Product.builder().name("상품명4").price(BigDecimal.ONE).category(Category.ELECTRIC).build(),
				Product.builder().name("상품명6").price(BigDecimal.ONE).category(Category.ELECTRIC).build(),
				Product.builder().name("상품명3").price(BigDecimal.ONE).category(Category.ELECTRIC).build(),
				Product.builder().name("상품명1").price(BigDecimal.TEN).category(Category.FOOD).build(),
				Product.builder().name("상품명5").price(BigDecimal.ONE).category(Category.ELECTRIC).build(),
				Product.builder().name("상품명2").price(BigDecimal.ONE).category(Category.ELECTRIC).build(),
				Product.builder().name("상품명7").price(BigDecimal.ONE).category(Category.ETC).build(),
				Product.builder().name("상품명8").price(BigDecimal.TEN).category(Category.FOOD).build()
				);		
	}
	
	public static Product product() {
		return Product.builder().name("상품명4").price(BigDecimal.ONE).category(Category.ELECTRIC).build();
	}

}
