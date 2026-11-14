package com.example.backend.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.entity.ProductOfferings;
import lombok.RequiredArgsConstructor;
import com.example.backend.service.ProductOfferingsService;

import java.util.List;

@RestController()
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductOfferingsController {

    private final ProductOfferingsService productOfferingsService;

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
    public ResponseEntity<ProductOfferings> findByNameAndColor(@RequestParam("name") String name,
                                                               @RequestParam("color") String color) {
        ProductOfferings productOfferings = productOfferingsService.findByNameAndColor(name,color);
        return ResponseEntity.ok(productOfferings);
    }
}
