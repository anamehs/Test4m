package com.example.test4m.services.impl;

import com.example.test4m.entity.Product;
import com.example.test4m.repositories.InMemoryProductRepository;
import com.example.test4m.services.ProductService;
import com.example.test4m.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final InMemoryProductRepository inMemoryProductRepository;
    private final UserService userService;

    @Override
    public List<Product> getAllProducts() {
        return inMemoryProductRepository.getAllProducts();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return inMemoryProductRepository.getProductById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return inMemoryProductRepository.getProductByName(name);
    }

    @Override
    public Optional<Product> getProductByCategory(String category) {
        return inMemoryProductRepository.getProductByCategory(category);
    }

    @Override
    public Product addProduct(Product product) {
        return inMemoryProductRepository.addProduct(product);
    }
    @Override
    public List<Product> getAbovePrice(float price){
        return inMemoryProductRepository.getAbovePrice(price);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (getProductById(id).isPresent()) {
            product.setId(id);
            return addProduct(product);
        }
        else{
            throw new IllegalArgumentException("Not found product to update");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        inMemoryProductRepository.deleteProduct(id);
    }
}
