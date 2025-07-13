package com.example.test4m.repositories.impl;

import com.example.test4m.entity.Product;
import com.example.test4m.repositories.InMemoryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class inMemoryProductRepository implements InMemoryProductRepository {
    public List<Product> products = new ArrayList<>();
    public Long id = 1l;
    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst();
    }
    @Override
    public Optional<Product> getProductByCategory(String category) {
        return products.stream().filter(p -> p.getCategory().equals(category)).findFirst();
    }

    @Override
    public Product addProduct(Product product) {
        if (product != null) {
           if (products.stream().filter(p -> p.getId().equals(product.getId())).findFirst().orElse(null) == null){
               product.setId(id);
               id += 1;
               products.add(product);
               return product;
           };
           return null;
        }
        else {
            return null;
        }
    }



    @Override
    public void deleteProduct(Long id) {
        if (id != null){
            products.stream().filter(p -> p.getId().equals(id)).findFirst().ifPresent(products::remove);
        }
    }
}
