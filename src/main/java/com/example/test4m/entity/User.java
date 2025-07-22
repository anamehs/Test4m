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
@Table(name = "users", schema="test")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(name = "c_name", unique = true, nullable = false)
    String name;
    @Column(name = "c_age", unique = true, nullable = false)
    int age;
    @Column(name = "c_city", unique = true, nullable = true)
    String city;

}
