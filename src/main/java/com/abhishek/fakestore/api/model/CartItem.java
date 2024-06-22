package com.abhishek.fakestore.api.model;

import lombok.Data;

@Data
public class CartItem {
    private Long productId;
    private int quantity;
}