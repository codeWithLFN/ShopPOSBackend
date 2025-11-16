package com.codewithlfn.shopbackend.service;

import com.codewithlfn.shopbackend.dto.request.CreateProductRequest;
import com.codewithlfn.shopbackend.dto.response.GenericMessageResponse;
import com.codewithlfn.shopbackend.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    GenericMessageResponse createProduct(List<CreateProductRequest> request);
    List<ProductResponse> getAllProducts();
}
