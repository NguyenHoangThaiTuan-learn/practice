package com.example.backend.service;

import java.util.List;

import com.example.backend.dto.request.ProductDetailCreateRequest;
import com.example.backend.entity.ProductDetail;

public interface ProductDetailService {
    List<ProductDetail> getAll();

    ProductDetail create(ProductDetailCreateRequest request);
}
