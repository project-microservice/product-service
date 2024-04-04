package com.project.product.service;

import com.project.product.dto.ProductDto;
import com.project.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    void createProduct(ProductDto[] productDto);
    List<ProductDto> getProductsByCategoryId(Long categoryId);
}
