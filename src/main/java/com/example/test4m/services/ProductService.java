package com.example.test4m.services;

import com.example.test4m.entity.Product;
import com.example.test4m.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Optional<Product> getProductByName(String name);
    Optional<Product> getProductByCategory(String category);;
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    List<Product> getAbovePrice(float price);
    void deleteProduct(Long id);
}
