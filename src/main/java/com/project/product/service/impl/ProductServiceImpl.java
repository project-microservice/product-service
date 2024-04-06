package com.project.product.service.impl;

import com.project.product.entity.Product;
import com.project.product.payload.request.ProductRequest;
import com.project.product.payload.response.ProductDetailResponse;
import com.project.product.payload.response.ProductResponse;
import com.project.product.repository.CategoryRepository;
import com.project.product.repository.ProductRepository;
import com.project.product.service.AttributeService;
import com.project.product.service.ProductGalleryService;
import com.project.product.service.ProductService;
import com.project.product.utils.CheckAvailability;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttributeService attributeService;
    private final ProductGalleryService productGalleryService;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(element -> {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(element, productResponse);
            return productResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public void createProducts(ProductRequest[] listProducts) {
        Arrays.stream(listProducts).forEach(element -> {
            Product product = new Product();
            BeanUtils.copyProperties(element, product);
            Product savedProduct = productRepository.save(product);
            attributeService.createAttribute(element.getListAttributes(), savedProduct);
            productGalleryService.createProductGallery(savedProduct, element.getListImages());
        });
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(Long categoryId) {
        if (categoryId == 0) return getAllProducts();
        CheckAvailability.checkOptionalEntity(categoryRepository, categoryId, "Category", "id");
        return productRepository.getListProductByCategoryId(categoryId).stream().map(element -> {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(element, productResponse);
            return productResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductDetailResponse getProductDetail(Long productId) {
        return null;
    }
}
