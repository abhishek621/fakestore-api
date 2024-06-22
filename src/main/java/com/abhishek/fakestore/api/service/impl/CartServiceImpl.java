package com.abhishek.fakestore.api.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhishek.fakestore.api.model.Cart;
import com.abhishek.fakestore.api.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Value("${fakestore.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public CartServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Cart> getAllCarts() {
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(apiUrl + "/carts", Cart[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public Cart getCartById(Long id) {
        return restTemplate.getForObject(apiUrl + "/carts/" + id, Cart.class);
    }

    @Override
    public List<Cart> getCartsLimited(int limit) {
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(apiUrl + "/carts?limit=" + limit, Cart[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Cart> getCartsSorted(String sort) {
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(apiUrl + "/carts?sort=" + sort, Cart[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Cart> getCartsByDateRange(LocalDate startDate, LocalDate endDate) {
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(
                apiUrl + "/carts?startdate=" + startDate + "&enddate=" + endDate, Cart[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Cart> getUserCarts(Long userId) {
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(apiUrl + "/carts/user/" + userId, Cart[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public Cart addCart(Cart cart) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Cart> request = new HttpEntity<>(cart, headers);
        ResponseEntity<Cart> response = restTemplate.exchange(apiUrl + "/carts",
                HttpMethod.POST,
                request,
                Cart.class);

        return response.getBody();
    }

    @Override
    public Cart updateCart(Long id, Cart cart) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Cart> request = new HttpEntity<>(cart, headers);
        ResponseEntity<Cart> response = restTemplate.exchange(apiUrl + "/carts/" + id,
                HttpMethod.PUT,
                request,
                Cart.class);

        return response.getBody();
    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete(apiUrl + "/carts/" + id);
    }
}
