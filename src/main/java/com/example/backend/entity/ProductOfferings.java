package com.example.backend.entity;

import java.io.Serializable;

import com.example.backend.common.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_offerings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOfferings implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "color")
    private String color;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
