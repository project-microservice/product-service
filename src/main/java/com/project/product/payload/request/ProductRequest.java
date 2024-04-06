package com.project.product.payload.request;

import lombok.Data;

import java.util.List;
@Data
public class ProductRequest {
    private Long id;
    private String type;
    private String productName;
    private Double regularPrice;
    private Integer stockQuantity;
    private Double productWeight;
    private List<AttributeNameAndValueRequest> listAttributes;
    private List<ProductGalleryRequest> listImages;
}
