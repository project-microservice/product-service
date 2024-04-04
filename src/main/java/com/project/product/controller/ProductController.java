package com.project.product.controller;

import com.project.product.dto.ProductDto;
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
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(
            @RequestParam(defaultValue = "0", required = false) Long categoryId
    ) {
        List<ProductDto> products = productService.getProductsByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDto[] productDto) {
        productService.createProduct(productDto);
        return new ResponseEntity<>("Create product successfully", HttpStatus.CREATED);
    }
}
