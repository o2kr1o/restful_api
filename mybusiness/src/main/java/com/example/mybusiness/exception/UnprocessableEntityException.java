package com.example.mybusiness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/** Exception class for 422 error */
public class UnprocessableEntityException extends ResponseStatusException {

	public UnprocessableEntityException(HttpStatus status, String reason) {
		super(status, reason);
	}

}
