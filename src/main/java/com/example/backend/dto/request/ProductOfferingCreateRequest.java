package com.example.backend.dto.request;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOfferingCreateRequest implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "color")
    private String color;
}
