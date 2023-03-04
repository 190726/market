package com.sk.market.product.domain;

import java.util.UUID;

public class NoExistProductException extends RuntimeException{

	private final static String ERR_MESSAGE = "해당 상품이 존재하지 않습니다. ID:%s, 상품명:%s";
	
	public NoExistProductException(UUID id, String name, Throwable cause) {
		
		super(String.format(ERR_MESSAGE, id , name), cause);
	}

	public NoExistProductException(UUID id, String name) {
		super(String.format(ERR_MESSAGE, id , name));
	}
}