package com.project.product.service.impl;

import com.project.product.dto.CategoryDto;
import com.project.product.entity.Category;
import com.project.product.repository.CategoryRepository;
import com.project.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public void createCategory(CategoryDto[] categoryDto) {
        Arrays.stream(categoryDto).forEach(element -> {
            Category categoryEntity = new Category();
            BeanUtils.copyProperties(element, categoryEntity);
            categoryRepository.save(categoryEntity);
        });
    }
    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(category -> {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category, categoryDto);
            return categoryDto;
        }).collect(Collectors.toList());
    }

}
