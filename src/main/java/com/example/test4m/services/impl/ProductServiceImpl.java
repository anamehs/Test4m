package com.example.test4m.services.impl;

import com.example.test4m.entity.Product;
import com.example.test4m.repositories.InMemoryProductRepository;
import com.example.test4m.repositories.ProductRepository;
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
    private final ProductRepository inMemoryProductRepository;

    @Override
    public List<Product> getAllProducts() {
        return inMemoryProductRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return inMemoryProductRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProductByCategory(String category) {
        return Optional.empty();
    }

    @Override
    public Product addProduct(Product product) {
        return inMemoryProductRepository.save(product);
    }
    @Override
    public List<Product> getAbovePrice(float price){
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (getProductById(id).isPresent()) {
            product.setId(id);
            return inMemoryProductRepository.save(product);
        }
        else{
            throw new IllegalArgumentException("Not found product to update");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        inMemoryProductRepository.deleteById(id);
    }
}
