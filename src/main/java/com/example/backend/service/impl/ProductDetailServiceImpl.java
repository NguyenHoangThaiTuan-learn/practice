package com.example.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.dto.request.ProductDetailCreateRequest;
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

    @Override
    public ProductDetail create(ProductDetailCreateRequest request) {
        ProductDetail productDetail = ProductDetail.builder()
                .weight(request.getWeight())
                .feature(request.getFeature())
                .power(request.getPower())
                .brand(request.getBrand())
                .image(request.getImage())
                .video(request.getVideo())
                .build();
        return productDetailRepository.save(productDetail);
    }
}
