package com.project.product.controller;

import com.project.product.dto.ProductCategoryDto;
import com.project.product.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-category")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    @PostMapping
    public ResponseEntity<String> addProductToCategory(@RequestBody ProductCategoryDto[] productCategoryDto) {
        String result = productCategoryService.addProductToCategory(productCategoryDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
