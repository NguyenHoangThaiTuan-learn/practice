package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.ProductOfferings;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long> {}
