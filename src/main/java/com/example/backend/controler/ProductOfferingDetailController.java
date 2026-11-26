package com.example.backend.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.request.AssignProductDetailDetailRequest;
import com.example.backend.entity.ProductOfferings;
import com.example.backend.service.ProductOfferingDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product-offering-details")
@RequiredArgsConstructor
public class ProductOfferingDetailController {
    private final ProductOfferingDetailService productOfferingDetailService;

    @PostMapping()
    public ResponseEntity<ProductOfferings> assignProductDetail(@RequestBody AssignProductDetailDetailRequest request) {
        return ResponseEntity.ok(productOfferingDetailService.assignProductDetail(request));
    }
}
