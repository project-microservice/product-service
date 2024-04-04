package com.project.product.service.impl;

import com.project.product.entity.Attribute;
import com.project.product.repository.AttributeRepository;
import com.project.product.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;

    @Override
    public Attribute createAttribute(String attributeName) {
        Attribute attribute = new Attribute();
        attribute.setAttributeName(attributeName);
        return attributeRepository.save(attribute);
    }
}
