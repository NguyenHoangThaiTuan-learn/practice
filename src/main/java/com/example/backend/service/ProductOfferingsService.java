package com.example.backend.service;

import java.util.List;

import com.example.backend.dto.request.ProductOfferingCreateRequest;
import com.example.backend.entity.ProductOfferings;

public interface ProductOfferingsService {
    ProductOfferings getById(Long id);

    List<ProductOfferings> getAll();

    ProductOfferings findByName(String name);

    ProductOfferings findByNameAndColor(String name, String color);

    ProductOfferings create(ProductOfferingCreateRequest request);

    ProductOfferings update(Long id, ProductOfferings productOfferings);
}
