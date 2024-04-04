package com.project.product.service.impl;

import com.project.product.dto.ProductDto;
import com.project.product.entity.Attribute;
import com.project.product.entity.Product;
import com.project.product.repository.CategoryRepository;
import com.project.product.repository.ProductRepository;
import com.project.product.service.AttributeService;
import com.project.product.service.AttributeValueService;
import com.project.product.service.ProductAttributeService;
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
    private final AttributeValueService attributeValueService;
    private final ProductAttributeService productAttributeService;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(element -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(element, productDto);
            return productDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createProduct(ProductDto[] productDto) {
        Arrays.stream(productDto).forEach(element -> {
            Product product = new Product();
            BeanUtils.copyProperties(element, product);
            Product savedProduct = productRepository.save(product);
            element.getListAttributes().forEach(_attribute -> {
                Attribute savedAttribute = attributeService.createAttribute(_attribute.getAttributeName());
                attributeValueService.createAttributeValue(_attribute.getAttributeValue(), savedAttribute);
                productAttributeService.createProductAttribute(savedProduct.getId(), savedAttribute.getId());
            });
        });
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        if (categoryId == 0) return getAllProducts();
        CheckAvailability.checkOptionalEntity(categoryRepository, categoryId, "Category", "id");
        return productRepository.getListProductByCategoryId(categoryId).stream().map(element -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(element, productDto);
            return productDto;
        }).collect(Collectors.toList());
    }
}
