package com.codewithlfn.shopbackend.controller;

import com.codewithlfn.shopbackend.dto.request.CreateProductRequest;
import com.codewithlfn.shopbackend.dto.response.GenericMessageResponse;
import com.codewithlfn.shopbackend.dto.response.ProductResponse;
import com.codewithlfn.shopbackend.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/v1/products")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/api/v1/addProduct")
    public GenericMessageResponse createProduct(
            @Valid
            @NotEmpty (message = "Product list cannot be empty")
            @RequestBody
            List<CreateProductRequest> request) {
        return productService.createProduct(request);
    }
}
