package com.example.test4m.controllers;

import com.example.test4m.entity.Product;
import com.example.test4m.entity.User;
import com.example.test4m.services.ProductService;
import com.example.test4m.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestParam Long id, @RequestBody Product product) {
        try{
            return ResponseEntity.ok(productService.updateProduct(id, product));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductById(@PathVariable String name) {
        return productService.getProductByName(name).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        if (productService.getProductById(id).isPresent()){
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
}
