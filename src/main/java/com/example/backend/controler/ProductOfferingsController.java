package com.example.backend.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.request.ProductOfferingCreateRequest;
import com.example.backend.entity.ProductOfferings;
import com.example.backend.service.ProductOfferingsService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductOfferingsController {

    private final ProductOfferingsService productOfferingsService;

    @GetMapping("/filter")
    public ResponseEntity<List<ProductOfferings>> filter(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "minPrice", required = false) Long minPrice,
            @RequestParam(name = "maxPrice", required = false) Long maxPrice,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "status", required = false) String status) {
        return ResponseEntity.ok(productOfferingsService.filter(name, minPrice, maxPrice, color, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOfferings> getById(@PathVariable("id") Long id) {
        ProductOfferings productOfferings = productOfferingsService.getById(id);
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping()
    public ResponseEntity<List<ProductOfferings>> getAll() {
        List<ProductOfferings> productOfferings = productOfferingsService.getAll();
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping("/name")
    public ResponseEntity<ProductOfferings> findByName(@RequestParam("name") String name) {
        ProductOfferings productOfferings = productOfferingsService.findByName(name);
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping("/name-color")
    public ResponseEntity<ProductOfferings> findByNameAndColor(
            @RequestParam("name") String name, @RequestParam("color") String color) {
        ProductOfferings productOfferings = productOfferingsService.findByNameAndColor(name, color);
        return ResponseEntity.ok(productOfferings);
    }

    @PostMapping()
    public ResponseEntity<ProductOfferings> create(@RequestBody ProductOfferingCreateRequest request) {
        return ResponseEntity.ok(productOfferingsService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOfferings> update(@PathVariable("id") Long id, @RequestBody ProductOfferings request) {
        return ResponseEntity.ok(productOfferingsService.update(id, request));
    }
}
