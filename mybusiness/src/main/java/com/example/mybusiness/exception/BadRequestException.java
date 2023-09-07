package com.example.mybusiness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/** Exception class for 400 error */
public class BadRequestException extends ResponseStatusException {

	public BadRequestException(HttpStatus status, String reason) {
		super(status, reason);
	}

}
