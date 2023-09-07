package com.example.mybusiness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/** Exception class for 500 error */
public class InternalServerError extends ResponseStatusException {

	public InternalServerError(HttpStatus status, String reason) {
		super(status, reason);
	}

}
