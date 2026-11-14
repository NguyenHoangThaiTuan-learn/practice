package com.example.backend.service;

import com.example.backend.entity.ProductOfferings;

import java.util.List;

public interface ProductOfferingsService {
    ProductOfferings getById(Long id);

    List<ProductOfferings> getAll();

    ProductOfferings findByName(String name);

    ProductOfferings findByNameAndColor(String name, String color);
}
