package com.project.product.service;

import com.project.product.dto.CategoryDto;
import com.project.product.entity.Category;
import com.project.product.entity.Product;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryDto[] categoryDto);
    List<Category> getAllCategories();
}
