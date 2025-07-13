package com.example.test4m.repositories;

import com.example.test4m.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InMemoryProductRepository {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Optional<Product> getProductByName(String name);
    Optional<Product> getProductByCategory(String category);;
    Product addProduct(Product product);
    List<Product> getAbovePrice(float price);
    void deleteProduct(Long id);
}
