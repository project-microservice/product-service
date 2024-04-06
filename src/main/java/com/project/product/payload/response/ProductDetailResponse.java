package com.project.product.payload.response;

import com.project.product.payload.request.AttributeNameAndValueRequest;
import com.project.product.payload.request.ProductGalleryRequest;
import lombok.Data;

import java.util.List;
@Data
public class ProductDetailResponse {
    private Long id;
    private String type;
    private String productName;
    private Double regularPrice;
    private Integer stockQuantity;
    private Double productWeight;
    private List<AttributeNameAndValueRequest> listAttributes;
    private List<ProductGalleryRequest> listImages;
}
