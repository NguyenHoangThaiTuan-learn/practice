package com.example.backend.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.ProductOfferings;
import lombok.RequiredArgsConstructor;
import com.example.backend.service.ProductOfferingsService;

@RestController
@RequiredArgsConstructor
public class ProductOfferingsController {

    private final ProductOfferingsService productOfferingsService;

    @GetMapping("products")
    public ResponseEntity<ProductOfferings> getById(Long id) {
        ProductOfferings productOfferings = productOfferingsService.getById(1L);
        return ResponseEntity.ok(productOfferings);
    }
}
