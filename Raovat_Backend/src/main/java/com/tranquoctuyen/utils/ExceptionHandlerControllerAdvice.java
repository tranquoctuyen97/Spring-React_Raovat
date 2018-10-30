package com.tranquoctuyen.utils;

import javax.servlet.http.HttpServletRequest;


import org.hibernate.JDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody Reponse handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		Reponse error = new Reponse();
		error.setNotification(exception.getMessage());
		error.setSuccess(false);

		return error;
	}

	@ExceptionHandler(JDBCException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Reponse handleException(final JDBCException exception,
			final HttpServletRequest request) {

		Reponse error = new Reponse();
		error.setNotification(exception.getCause().getMessage());
		error.setSuccess(false);

		return error;
	}
//	@ExceptionHandler(javax.validation.ConstraintViolationException.class)

	

}