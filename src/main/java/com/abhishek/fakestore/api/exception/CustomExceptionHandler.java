package com.abhishek.fakestore.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.abhishek.fakestore.api.constants.FakeStoreApiConstants;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setCode(FakeStoreApiConstants.ERR_404);
		errorResponse.setMessage(FakeStoreApiConstants.ERR_404_MSG);
		errorResponse.setDeveloperMessage(FakeStoreApiConstants.DATA_NOT_FOUND);
		errorResponse.setMoreInfo(FakeStoreApiConstants.DEVELOPER_MESSAGE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setCode(FakeStoreApiConstants.ERR_404);
		errorResponse.setMessage(FakeStoreApiConstants.ERR_404_MSG);
		errorResponse.setDeveloperMessage(FakeStoreApiConstants.DATA_NOT_FOUND);
		errorResponse.setMoreInfo(FakeStoreApiConstants.DEVELOPER_MESSAGE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleCartNotFoundException(CartNotFoundException ex) {
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setCode(FakeStoreApiConstants.ERR_404);
		errorResponse.setMessage(FakeStoreApiConstants.ERR_404_MSG);
		errorResponse.setDeveloperMessage(FakeStoreApiConstants.DATA_NOT_FOUND);
		errorResponse.setMoreInfo(FakeStoreApiConstants.DEVELOPER_MESSAGE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<CustomErrorResponse> handleAuthenticationException(AuthException ex) {
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setCode(FakeStoreApiConstants.ERR_404);
		errorResponse.setMessage(FakeStoreApiConstants.ERR_404_MSG);
		errorResponse.setDeveloperMessage(FakeStoreApiConstants.DATA_NOT_FOUND);
		errorResponse.setMoreInfo(FakeStoreApiConstants.DEVELOPER_MESSAGE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
