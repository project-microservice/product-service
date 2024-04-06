package com.project.product.service;

import com.project.product.entity.Attribute;
import com.project.product.entity.Product;
import com.project.product.payload.request.AttributeNameAndValueRequest;

import java.util.List;
import java.util.Optional;

public interface AttributeService {
    Attribute createAttribute(String attributeName);
    Optional<Attribute> checkAvailabilityOfAttributeByName(String attributeName);

    void createAttribute(List<AttributeNameAndValueRequest> list,  Product savedProduct);
}
