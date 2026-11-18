package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.entity.ProductOfferings;

public interface ProductOfferingRepository extends JpaRepository<ProductOfferings, Long> {
    Optional<ProductOfferings> findByName(String name);

    Optional<ProductOfferings> findByNameAndColor(String name, String color);

    @Query("""
			SELECT po
			FROM ProductOfferings po
			WHERE po.id IN (
						SELECT pod.productOfferings.id
						FROM ProductOfferingDetail pod
						WHERE pod.productDetail.id = :id
						)
			""")
    List<ProductOfferings> findByDetailId(@Param("id") Long id);
}
