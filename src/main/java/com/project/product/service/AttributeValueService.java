package com.project.product.service;

import com.project.product.entity.Attribute;
import com.project.product.entity.AttributeValue;

public interface AttributeValueService {
    void createAttributeValue(String attributeValue, Attribute attribute);
}
