package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.ProductOfferings;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long> {
    Optional<ProductOfferings> findByName(String name);

    Optional<ProductOfferings> findByNameAndColor(String name, String color);
}
