package com.abhishek.fakestore.api.service;

import java.util.List;

import com.abhishek.fakestore.api.model.Category;
import com.abhishek.fakestore.api.model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductsLimited(int limit);
    List<Product> getProductsSorted(String sort);
    List<Category> getAllCategories();
    List<Product> getProductsByCategory(String category);
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
