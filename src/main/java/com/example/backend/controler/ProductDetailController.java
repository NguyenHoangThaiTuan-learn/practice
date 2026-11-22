package com.example.backend.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.request.ProductDetailCreateRequest;
import com.example.backend.entity.ProductDetail;
import com.example.backend.service.ProductDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product-details")
@RequiredArgsConstructor
public class ProductDetailController {
    private final ProductDetailService productDetailService;

    @GetMapping()
    public ResponseEntity<List<ProductDetail>> getAll() {
        List<ProductDetail> productDetails = productDetailService.getAll();
        return ResponseEntity.ok(productDetails);
    }

    @PostMapping()
    public ResponseEntity<ProductDetail> create(@RequestBody ProductDetailCreateRequest request) {
        return ResponseEntity.ok(productDetailService.create(request));
    }
}
