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
        Product createdProduct = productService.addProduct(product);
        if (!(createdProduct == null)) {
            return ResponseEntity.ok(createdProduct);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestParam Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (!(updatedProduct == null)) {
            return ResponseEntity.ok(updatedProduct);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product gottenProduct = productService.getProductById(id).orElse(null);
        if (!(gottenProduct == null)) {
            return ResponseEntity.ok(gottenProduct);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<Product> getProductByCategory(@PathVariable String category) {
        Product gottenProduct = productService.getProductByCategory(category).orElse(null);
        if (!(gottenProduct == null)) {
            return ResponseEntity.ok(gottenProduct);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductById(@PathVariable String name) {
        Product gottenProduct = productService.getProductByName(name).orElse(null);
        if (!(gottenProduct == null)) {
            return ResponseEntity.ok(gottenProduct);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        if (productService.getProductById(id) != null){
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
}
