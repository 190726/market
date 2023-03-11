package com.sk.market.product.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sk.market.product.domain.NoExistProductException;
import com.sk.market.product.domain.WrongFormatProductException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackageClasses = {ProductController.class})
public class ProductExceptionAdvice {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({NoExistProductException.class, WrongFormatProductException.class})
	public ErrorResult productExceptionHandle(RuntimeException e){
		log.error("product error message : {}", e.getMessage());
		return new ErrorResult("BAD", e.getMessage());
	}
}
