package com.codewithlfn.shopbackend.service.impl;

import com.codewithlfn.shopbackend.dto.request.CreateProductRequest;
import com.codewithlfn.shopbackend.dto.response.GenericMessageResponse;
import com.codewithlfn.shopbackend.dto.response.ProductResponse;
import com.codewithlfn.shopbackend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // Method to create products
    @Override
    public GenericMessageResponse createProduct(List<CreateProductRequest> request) {
        return GenericMessageResponse.builder()
                .message("Product/s created successfully")
                .build();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        ProductResponse product = ProductResponse.builder()
                .productId("1")
                .name("Sample Product")
                .description("This is a sample product")
                .quantity(10)
                .price(null)
                .build();

        ProductResponse product2 = ProductResponse.builder()
                .productId("2")
                .name("Another Product")
                .description("This is another sample product")
                .quantity(5)
                .price(null)
                .build();

        return List.of(product, product2);
    }
}
