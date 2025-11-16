package com.codewithlfn.shopbackend.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Integer productId;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
}
