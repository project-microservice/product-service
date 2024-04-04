package com.project.product.dto;

import com.project.product.payload.request.AttributeNameAndValue;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String type;
    private String productName;
    private Double regularPrice;
    private Integer stockQuantity;
    private Double productWeight;
    private List<AttributeNameAndValue> listAttributes;
}
