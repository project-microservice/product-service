package com.project.product.service;

import com.project.product.payload.request.ProductRequest;
import com.project.product.payload.response.ProductDetailResponse;
import com.project.product.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    void createProducts(ProductRequest[] listProducts);
    List<ProductResponse> getProductsByCategoryId(Long categoryId);
    ProductDetailResponse getProductDetail(Long productId);
}
