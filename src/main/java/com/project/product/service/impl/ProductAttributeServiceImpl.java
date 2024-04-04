package com.project.product.service.impl;

import com.project.product.entity.ProductAttribute;
import com.project.product.entity.embeddedId.ProductAttributeId;
import com.project.product.repository.ProductAttributeRepository;
import com.project.product.service.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;

    @Override
    public void createProductAttribute(Long productId, Long attributeId) {
        ProductAttribute productAttribute = new ProductAttribute();
        ProductAttributeId productAttributeId = new ProductAttributeId();
        productAttributeId.setProductId(productId);
        productAttributeId.setAttributeId(attributeId);

        productAttribute.setProductAttributeId(productAttributeId);
        productAttributeRepository.save(productAttribute);
    }
}
