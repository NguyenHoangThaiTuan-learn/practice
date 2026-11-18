package com.example.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.entity.ProductDetail;
import com.example.backend.repository.ProductDetailRepository;
import com.example.backend.service.ProductDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> getAll() {
        List<ProductDetail> productDetails = productDetailRepository.findAll();
        return productDetails;
    }
}
