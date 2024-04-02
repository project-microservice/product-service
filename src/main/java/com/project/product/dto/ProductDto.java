package com.project.product.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String type;
    private String productName;
    private Double regularPrice;
    private Integer stockQuantity;
    private Double productWeight;
}
