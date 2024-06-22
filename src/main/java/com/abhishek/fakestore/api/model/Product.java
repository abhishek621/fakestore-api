package com.abhishek.fakestore.api.model;

import lombok.Data;

@Data
public class Product {
	private Long id;
	private String title;
	private String description;
	private double price;
}
