package com.project.product.service.impl;

import com.project.product.dto.ProductDto;
import com.project.product.entity.Product;
import com.project.product.repository.ProductRepository;
import com.project.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productRepository.save(product);
    }
}
