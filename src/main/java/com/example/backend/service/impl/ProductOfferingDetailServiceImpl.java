package com.example.backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backend.dto.request.AssignProductDetailDetailRequest;
import com.example.backend.entity.ProductDetail;
import com.example.backend.entity.ProductOfferingDetail;
import com.example.backend.entity.ProductOfferings;
import com.example.backend.repository.ProductDetailRepository;
import com.example.backend.repository.ProductOfferingDetailRepository;
import com.example.backend.repository.ProductOfferingRepository;
import com.example.backend.service.ProductOfferingDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductOfferingDetailServiceImpl implements ProductOfferingDetailService {

    private final ProductOfferingDetailRepository productOfferingDetailRepository;
    private final ProductOfferingRepository productOfferingRepository;
    private final ProductDetailRepository productDetailRepository;

    @Override
    public ProductOfferings assignProductDetail(AssignProductDetailDetailRequest request) {
        if (request.getProductOfferingId() == null) {
            throw new RuntimeException("ProductOfferingId is null");
        }

        if (request.getProductDetailIds() == null
                || request.getProductDetailIds().isEmpty()) {
            throw new RuntimeException("Product Detail not null or empty");
        }

        Optional<ProductOfferings> productOfferings =
                productOfferingRepository.findById(request.getProductOfferingId());
        if (productOfferings.isEmpty()) {
            throw new RuntimeException("not found productOffering with id +" + request.getProductOfferingId());
        }

        List<ProductDetail> productDetails = productDetailRepository.findAllById(request.getProductDetailIds());
        if (productDetails.isEmpty()) {
            throw new RuntimeException("product detail is empty");
        }

        List<ProductOfferingDetail> productOfferingDetails = new ArrayList<>();
        for (int i = 0; i < productDetails.size(); i++) {
            ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();
            productOfferingDetail.setProductOfferings(productOfferings.get());
            productOfferingDetail.setProductDetail(productDetails.get(i));

            productOfferingDetails.add(productOfferingDetail);
        }

        productOfferingDetailRepository.saveAll(productOfferingDetails);

        productOfferings.get().setProductOfferingDetails(productOfferingDetails);
        return productOfferings.get();
    }
}
