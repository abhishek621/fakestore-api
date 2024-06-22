package com.abhishek.fakestore.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhishek.fakestore.api.model.Category;
import com.abhishek.fakestore.api.model.Product;
import com.abhishek.fakestore.api.service.ProductService;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${fakestore.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate;

	public ProductServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		Product[] products = restTemplate.getForObject(apiUrl, Product[].class);
		return Arrays.asList(products);
	}

	@Override
	public Product getProductById(Long id) {
		return restTemplate.getForObject(apiUrl + "/" + id, Product.class);
	}

	@Override
	public List<Product> getProductsLimited(int limit) {
		Product[] products = restTemplate.getForObject(apiUrl + "?limit=" + limit, Product[].class);
		return Arrays.asList(products);
	}

	@Override
	public List<Product> getProductsSorted(String sort) {
		Product[] products = restTemplate.getForObject(apiUrl + "?sort=" + sort, Product[].class);
		return Arrays.asList(products);
	}

	@Override
	public List<Category> getAllCategories() {
		ResponseEntity<Category[]> response = restTemplate.getForEntity(apiUrl + "/categories", Category[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(apiUrl + "/category/" + category,
				Product[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public Product addProduct(Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product, headers);
		ResponseEntity<Product> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, Product.class);

		return response.getBody();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Product> request = new HttpEntity<>(product, headers);
		ResponseEntity<Product> response = restTemplate.exchange(apiUrl + "/" + id, HttpMethod.PUT, request,
				Product.class);

		return response.getBody();
	}

	@Override
	public void deleteProduct(Long id) {
		restTemplate.delete(apiUrl + "/" + id);
	}
}
