package com.project.product.service;

import com.project.product.dto.ProductDto;
import com.project.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductDto product);

}
