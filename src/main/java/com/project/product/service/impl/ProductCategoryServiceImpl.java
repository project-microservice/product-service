package com.project.product.service.impl;

import com.project.product.dto.ProductCategoryDto;
import com.project.product.entity.Category;
import com.project.product.entity.Product;
import com.project.product.entity.ProductCategory;
import com.project.product.entity.embeddedId.ProductCategoryId;
import com.project.product.exception.ResourceExistedException;
import com.project.product.repository.CategoryRepository;
import com.project.product.repository.ProductAttributeRepository;
import com.project.product.repository.ProductCategoryRepository;
import com.project.product.repository.ProductRepository;
import com.project.product.service.ProductCategoryService;
import com.project.product.utils.CheckAvailability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public String addProductToCategory(ProductCategoryDto[] listproductCategoryDto) {
        Arrays.stream(listproductCategoryDto).forEach((element) -> {

            Product product = CheckAvailability.checkOptionalEntity(
                    productRepository,
                    element.getProductId(),
                    "Product",
                    "id"
            );

            Category category = CheckAvailability.checkOptionalEntity(
                    categoryRepository,
                    element.getCategoryId(),
                    "Category",
                    "id"
            );

            ProductCategoryId productCategoryId = new ProductCategoryId(
                    product.getId(),
                    category.getId()
            );

            if (productCategoryRepository.existsById(productCategoryId)) {
                throw new ResourceExistedException("Connection existed");
            }

            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(new ProductCategoryId(product.getId(), category.getId()));
            productCategoryRepository.save(productCategory);
        });

        return "Create successfully";
    }


}
