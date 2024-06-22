package com.abhishek.fakestore.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhishek.fakestore.api.model.User;
import com.abhishek.fakestore.api.service.UserService;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Value("${user.fakestore.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate;

	public UserServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getAllUsers() {
		ResponseEntity<User[]> response = restTemplate.getForEntity(apiUrl, User[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public User getUserById(Long id) {
		return restTemplate.getForObject(apiUrl +"/" + id, User.class);
	}

	@Override
	public List<User> getUsersLimited(int limit) {
		ResponseEntity<User[]> response = restTemplate.getForEntity(apiUrl + "?limit=" + limit, User[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public List<User> getUsersSorted(String sort) {
		ResponseEntity<User[]> response = restTemplate.getForEntity(apiUrl + "?sort=" + sort, User[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public User addUser(User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<User> request = new HttpEntity<>(user, headers);
		ResponseEntity<User> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, User.class);

		return response.getBody();
	}

	@Override
	public User updateUser(Long id, User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<User> request = new HttpEntity<>(user, headers);
		ResponseEntity<User> response = restTemplate.exchange(apiUrl + "/" + id, HttpMethod.PUT, request, User.class);

		return response.getBody();
	}

	@Override
	public void deleteUser(Long id) {
		restTemplate.delete(apiUrl + "/" + id);
	}
}
