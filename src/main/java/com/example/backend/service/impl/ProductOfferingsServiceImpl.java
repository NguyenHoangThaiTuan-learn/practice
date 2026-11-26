package com.example.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.example.backend.common.StatusEnum;
import com.example.backend.dto.request.ProductOfferingCreateRequest;
import com.example.backend.entity.ProductOfferings;
import com.example.backend.repository.ProductOfferingRepository;
import com.example.backend.service.ProductOfferingsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductOfferingsServiceImpl implements ProductOfferingsService {

    private final ProductOfferingRepository productOfferingRepo;

    private final EntityManager entityManager;

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
                .findByNameAndColor(name, color)
                .orElseThrow(() ->
                        new EntityNotFoundException("Can not find product with name " + name + " and color " + color));
        return product;
    }

    @Override
    public ProductOfferings create(ProductOfferingCreateRequest request) {
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
        ProductOfferings entity = productOfferingRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found product with id " + id));

        entity.setColor(request.getColor());
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());

        entity = productOfferingRepo.save(entity);

        return entity;
    }

    @Override
    public List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductOfferings> query = criteriaBuilder.createQuery(ProductOfferings.class);

        Root<ProductOfferings> root = query.from(ProductOfferings.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
            predicates.add(predicate);
        }

        if (minPrice != null) {
            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            predicates.add(predicate);
        }

        if (maxPrice != null) {
            Predicate predicate = criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            predicates.add(predicate);
        }

        if (color != null && !color.isEmpty()) {
            Predicate predicate = criteriaBuilder.equal(root.get("color"), color);
            predicates.add(predicate);
        }

        if (status != null && !status.isEmpty()) {
            Predicate predicate = criteriaBuilder.equal(root.get("status"), status);
            predicates.add(predicate);
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
