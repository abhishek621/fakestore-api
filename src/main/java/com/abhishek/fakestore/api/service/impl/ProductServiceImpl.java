package com.abhishek.fakestore.api.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.abhishek.fakestore.api.constants.FakeStoreApiConstants;
import com.abhishek.fakestore.api.exception.ProductNotFoundException;
import com.abhishek.fakestore.api.model.Category;
import com.abhishek.fakestore.api.model.Product;
import com.abhishek.fakestore.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${product.fakestore.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate;

	public ProductServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		Product[] products = restTemplate.getForObject(apiUrl, Product[].class);
		if (products == null) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return Arrays.asList(products);
	}

	@Override
	public Product getProductById(Long id) {
		Product product = restTemplate.getForObject(apiUrl + "/" + id, Product.class);
		if (product == null) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return product;
	}

	@Override
	public List<Product> getProductsLimited(int limit) {
		Product[] products = restTemplate.getForObject(apiUrl + "?limit=" + limit, Product[].class);
		if (products == null) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return Arrays.asList(products);
	}

	@Override
	public List<Product> getProductsSorted(String sort) {
		Product[] products = restTemplate.getForObject(apiUrl + "?sort=" + sort, Product[].class);
		if (products == null) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return Arrays.asList(products);
	}

	@Override
	public List<Category> getAllCategories() {
		ResponseEntity<Category[]> response = restTemplate.getForEntity(apiUrl + "/categories", Category[].class);
		if (response.getStatusCode() != HttpStatusCode.valueOf(200)) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return Arrays.asList(response.getBody());
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(apiUrl + "/category/" + category,
				Product[].class);
		if (response.getStatusCode() != HttpStatusCode.valueOf(200)) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return Arrays.asList(response.getBody());
	}

	@Override
	public Product addProduct(Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product, headers);
		ResponseEntity<Product> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, Product.class);
		if (response.getStatusCode() != HttpStatusCode.valueOf(200)) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return response.getBody();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product, headers);
		ResponseEntity<Product> response = restTemplate.exchange(apiUrl + "/" + id, HttpMethod.PUT, request,
				Product.class);
		if (response.getStatusCode() != HttpStatusCode.valueOf(200)) {
			throw new ProductNotFoundException(FakeStoreApiConstants.DATA_NOT_FOUND);
		}
		return response.getBody();
	}

	@Override
	public void deleteProduct(Long id) {
		restTemplate.delete(apiUrl + "/" + id);
	}
}
