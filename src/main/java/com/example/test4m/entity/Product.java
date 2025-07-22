package com.example.test4m.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products", schema = "test")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "c_name", unique = true, nullable = false)
    String name;
    @Column(name = "c_price", unique = true, nullable = false)
    Float price;
    @Column(name = "c_category", unique = true, nullable = true)
    String category;
    @Column(name = "c_description", unique = true, nullable = true)
    String description;
}
