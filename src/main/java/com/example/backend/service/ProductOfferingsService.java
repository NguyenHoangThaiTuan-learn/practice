package com.example.backend.service;

import java.util.List;

import com.example.backend.entity.ProductOfferings;

public interface ProductOfferingsService {
    ProductOfferings getById(Long id);

    List<ProductOfferings> getAll();

    ProductOfferings findByName(String name);

    ProductOfferings findByNameAndColor(String name, String color);

    ProductOfferings create(ProductOfferings productOfferings);

    ProductOfferings update(Long id, ProductOfferings productOfferings);
}
