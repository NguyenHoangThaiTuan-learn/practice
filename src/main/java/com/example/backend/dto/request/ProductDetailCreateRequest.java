package com.example.backend.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailCreateRequest implements Serializable {
    private Long weight;

    private String feature;

    private String power;

    private String brand;

    private String image;

    private String video;
}
