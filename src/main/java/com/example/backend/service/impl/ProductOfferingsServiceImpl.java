package com.example.backend.service.impl;

import com.example.backend.common.StatusEnum;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.example.backend.entity.ProductOfferings;
import lombok.RequiredArgsConstructor;
import com.example.backend.repository.ProductOfferingRepo;
import com.example.backend.service.ProductOfferingsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOfferingsServiceImpl implements ProductOfferingsService {

    private final ProductOfferingRepo productOfferingRepo;

    @Override
    public ProductOfferings getById(Long id) {
        ProductOfferings product = productOfferingRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not find product with id " + id));
        return product;
    }

    @Override
    public List<ProductOfferings> getAll() {
        return productOfferingRepo.findAll();
    }

    @Override
    public ProductOfferings findByName(String name) {
        ProductOfferings product = productOfferingRepo
                .findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Can not find product with name " + name));
        return product;
    }

    @Override
    public ProductOfferings findByNameAndColor(String name, String color) {
        ProductOfferings product = productOfferingRepo
                .findByNameAndColor(name,color)
                .orElseThrow(() -> new EntityNotFoundException("Can not find product with name " + name + " and color " + color));
        return product;
    }

    @Override
    public ProductOfferings create(ProductOfferings request) {
        ProductOfferings entity = ProductOfferings.builder()
                .color(request.getColor())
                .name(request.getName())
                .price(request.getPrice())
                .status(StatusEnum.INACTIVE)
                .build();
        return productOfferingRepo.save(entity);
    }

    @Override
    public ProductOfferings update(Long id, ProductOfferings request) {
        ProductOfferings entity = productOfferingRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("not found product with id "+id));

        entity.setColor(request.getColor());
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());

        entity = productOfferingRepo.save(entity);

        return entity;
    }
}
