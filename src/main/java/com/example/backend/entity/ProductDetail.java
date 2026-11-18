package com.example.backend.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetail implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "feature", length = 255)
    private String feature;

    @Column(name = "power")
    private String power;

    @Column(name = "brand")
    private String brand;

    @Column(name = "image")
    private String image;

    @Column(name = "video")
    private String video;

    //    @OneToMany(mappedBy = "productDetail")
    //    private List<ProductOfferings> productOfferings;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private List<ProductOfferingDetail> productDetails;
}
