package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.ProductOfferingDetail;

public interface ProductOfferingDetailRepository extends JpaRepository<ProductOfferingDetail, Long> {
    List<ProductOfferingDetail> findAllByProductOfferingsId(Long id);
}
