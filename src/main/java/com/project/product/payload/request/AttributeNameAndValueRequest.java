package com.project.product.payload.request;

import lombok.Data;

@Data
public class AttributeNameAndValueRequest {
    private String attributeName;
    private String attributeValue;
}
