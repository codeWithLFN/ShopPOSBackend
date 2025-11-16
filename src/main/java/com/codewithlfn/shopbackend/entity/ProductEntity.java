package com.codewithlfn.shopbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table (name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(nullable = false, length = 255)
        private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer stockQuantity;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
}
