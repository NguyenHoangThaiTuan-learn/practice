package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.ProductOfferings;

import java.util.Optional;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long> {
    Optional<ProductOfferings> findByName(String name);

    Optional<ProductOfferings> findByNameAndColor(String name, String color);
}
