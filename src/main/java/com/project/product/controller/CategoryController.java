package com.project.product.controller;

import com.project.product.dto.CategoryDto;
import com.project.product.entity.Category;
import com.project.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> products = categoryService.getAllCategories();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDto[] categoryDto) {
        categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category was created");
    }
}
