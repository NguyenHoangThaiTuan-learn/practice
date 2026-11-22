package com.example.backend.service;

import com.example.backend.dto.request.AssignProductDetailDetailRequest;
import com.example.backend.entity.ProductOfferings;

public interface ProductOfferingDetailService {
    ProductOfferings assignProductDetail(AssignProductDetailDetailRequest request);
}
