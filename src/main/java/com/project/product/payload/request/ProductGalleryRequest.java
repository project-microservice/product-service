package com.project.product.payload.request;

import lombok.Data;

@Data
public class ProductGalleryRequest {
    private String imagePath;
    private Boolean thumbnail;
}
