package com.capgemini.pecuniabankmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.pecuniabankmanagement.dto.Response;
import com.capgemini.pecuniabankmanagement.exception.CustomException;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public Response handleCustomerException(CustomException exception) {
		Response response = new Response();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(exception.getMessage());
		return response;
	}
}
