package com.example.backend.service.impl;

import org.springframework.stereotype.Service;

import com.example.backend.entity.ProductOfferings;
import lombok.RequiredArgsConstructor;
import com.example.backend.repository.ProductOfferingRepo;
import com.example.backend.service.ProductOfferingsService;

@Service
@RequiredArgsConstructor
public class ProductOfferingsServiceImpl implements ProductOfferingsService {

    private final ProductOfferingRepo productOfferingRepo;

    @Override
    public ProductOfferings getById(Long id) {
        ProductOfferings product = productOfferingRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Can not find product with id " + id));
        return product;
    }
}
