package com.project.product.payload.response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String type;
    private String productName;
    private Double regularPrice;
    private Integer stockQuantity;
    private Double productWeight;
}
