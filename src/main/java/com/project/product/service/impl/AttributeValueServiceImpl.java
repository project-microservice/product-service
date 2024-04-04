package com.project.product.service.impl;

import com.project.product.entity.Attribute;
import com.project.product.entity.AttributeValue;
import com.project.product.repository.AttributeValueRepository;
import com.project.product.service.AttributeValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {
    private final AttributeValueRepository attributeValueRepository;

    @Override
    public void createAttributeValue(String _attributeValue, Attribute attribute) {
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setAttributeValue(_attributeValue);
        attributeValue.setAttribute(attribute);
        attributeValueRepository.save(attributeValue);
    }
}
