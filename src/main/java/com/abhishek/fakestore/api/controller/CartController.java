package com.abhishek.fakestore.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.abhishek.fakestore.api.model.Cart;
import com.abhishek.fakestore.api.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	@GetMapping("/{id}")
	public Cart getCartById(@PathVariable Long id) {
		return cartService.getCartById(id);
	}

	@GetMapping("/limited")
	public List<Cart> getCartsLimited(@RequestParam(defaultValue = "5") int limit) {
		return cartService.getCartsLimited(limit);
	}

	@GetMapping("/sorted")
	public List<Cart> getCartsSorted(@RequestParam(defaultValue = "asc") String sort) {
		return cartService.getCartsSorted(sort);
	}

	@GetMapping("/date-range")
	public List<Cart> getCartsByDateRange(@RequestParam String startDate,@RequestParam String endDate) {
		return cartService.getCartsByDateRange(startDate, endDate);
	}

	@GetMapping("/user/{userId}")
    public List<Cart> getCartsByUserId(@PathVariable Long userId) {
        return cartService.getCartsByUserId(userId);
    }

	@PostMapping
	public Cart addCart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}

	@PutMapping("/{id}")
	public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) {
		return cartService.updateCart(id, cart);
	}

	@DeleteMapping("/{id}")
	public void deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
	}
}
