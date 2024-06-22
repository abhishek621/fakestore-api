package com.abhishek.fakestore.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AuthException extends RuntimeException {
	
	private static final long serialVersionUID = 17683256L;
	
	public AuthException(String message) {
		super(message);
	}

}
