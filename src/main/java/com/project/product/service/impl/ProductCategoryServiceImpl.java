package com.project.product.service.impl;

import com.project.product.dto.ProductCategoryDto;
import com.project.product.entity.Category;
import com.project.product.entity.Product;
import com.project.product.entity.ProductCategory;
import com.project.product.entity.embeddedId.ProductCategoryId;
import com.project.product.exception.ResourceNotFoundException;
import com.project.product.repository.CategoryRepository;
import com.project.product.repository.ProductCategoryRepository;
import com.project.product.repository.ProductRepository;
import com.project.product.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public String addProductToCategory(ProductCategoryDto productCategoryDto) {
        Optional<Product> optionalProduct = productRepository.findById(productCategoryDto.getProductId());
        if (optionalProduct.isEmpty()) throw new ResourceNotFoundException("Product", "product id", productCategoryDto.getCategoryId().toString());
        Optional<Category> optionalCategory = categoryRepository.findById(productCategoryDto.getCategoryId());
        if (optionalCategory.isEmpty()) throw new ResourceNotFoundException("Category", "category id", productCategoryDto.getCategoryId().toString());
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(new ProductCategoryId(optionalProduct.get().getId(), optionalCategory.get().getId()));
        productCategoryRepository.save(productCategory);
        return "Create successfully";
    }
}
