package com.project.product.service;

import com.project.product.entity.Product;
import com.project.product.payload.request.ProductGalleryRequest;

import java.util.List;

public interface ProductGalleryService {
    void createProductGallery(Product product, String imagePath, Boolean thumbnail);
    void createProductGallery(Product product, List<ProductGalleryRequest> list);

}
