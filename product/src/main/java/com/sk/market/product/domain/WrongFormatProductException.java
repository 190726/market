package com.sk.market.product.domain;

public class WrongFormatProductException extends RuntimeException{

	public WrongFormatProductException(String message) {
		super(message);
	}
}
