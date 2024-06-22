package com.abhishek.fakestore.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.abhishek.fakestore.api.constants.FakeStoreApiConstants;
import com.abhishek.fakestore.api.exception.AuthException;
import com.abhishek.fakestore.api.model.LoginRequest;
import com.abhishek.fakestore.api.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Value("${auth.fakestore.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate;

	public AuthServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String login(String username, String password) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername(username);
		loginRequest.setPassword(password);
		HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
		if (response.getStatusCode() != HttpStatusCode.valueOf(200)) {
			throw new AuthException(FakeStoreApiConstants.AUTHENTICATION_ERROR);
		}
		return response.getBody();
	}
}
