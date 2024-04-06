package com.project.product.controller;

import com.project.product.payload.request.ProductRequest;
import com.project.product.payload.response.ProductDetailResponse;
import com.project.product.payload.response.ProductResponse;
import com.project.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProductsByCategoryId(
            @RequestParam(defaultValue = "0", required = false) Long categoryId
    ) {
        List<ProductResponse> products = productService.getProductsByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> getProductDetail(@PathVariable Long id) {
        ProductDetailResponse productDetailResponse = productService.getProductDetail(id);
        return null;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest[] listProducts) {
        productService.createProducts(listProducts);
        return new ResponseEntity<>("Create product successfully", HttpStatus.CREATED);
    }
}
