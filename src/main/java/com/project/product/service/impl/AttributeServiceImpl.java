package com.project.product.service.impl;

import com.project.product.entity.Attribute;
import com.project.product.entity.Product;
import com.project.product.payload.request.AttributeNameAndValueRequest;
import com.project.product.repository.AttributeRepository;
import com.project.product.service.AttributeService;
import com.project.product.service.AttributeValueService;
import com.project.product.service.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;
    private final AttributeValueService attributeValueService;
    private final ProductAttributeService productAttributeService;

    @Override
    public Attribute createAttribute(String attributeName) {
        Attribute attribute = new Attribute();
        attribute.setAttributeName(attributeName);
        return attributeRepository.save(attribute);
    }

    @Override
    public Optional<Attribute> checkAvailabilityOfAttributeByName(String attributeName) {
        return attributeRepository.findByAttributeName(attributeName);
    }

    @Override
    public void createAttribute(List<AttributeNameAndValueRequest> list, Product savedProduct) {
        list.forEach(attribute -> {
            Optional<Attribute> optional = attributeRepository.findByAttributeName(attribute.getAttributeName());
            optional.ifPresentOrElse(
                    savedAttribute -> createAttributeValueAndProductAttribute(attribute.getAttributeValue(), savedProduct, savedAttribute),
                    () -> {
                        Attribute savedAttribute = createAttribute(attribute.getAttributeName());
                        createAttributeValueAndProductAttribute(attribute.getAttributeValue(), savedProduct, savedAttribute);
                    });
        });
    }

    private void createAttributeValueAndProductAttribute(String attributeValue, Product savedProduct, Attribute savedAttribute) {
        attributeValueService.createAttributeValue(attributeValue, savedAttribute);
        productAttributeService.createProductAttribute(savedProduct.getId(), savedAttribute.getId());
    }
}
