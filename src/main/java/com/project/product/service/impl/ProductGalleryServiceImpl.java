package com.project.product.service.impl;

import com.project.product.entity.Product;
import com.project.product.entity.ProductGallery;
import com.project.product.payload.request.ProductGalleryRequest;
import com.project.product.repository.ProductGalleryRepository;
import com.project.product.service.ProductGalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductGalleryServiceImpl implements ProductGalleryService {
    private final ProductGalleryRepository productGalleryRepository;
    @Override
    public void createProductGallery(Product product, String imagePath, Boolean thumbnail) {
        ProductGallery productGallery = new ProductGallery();
        productGallery.setProduct(product);
        productGallery.setImagePath(imagePath);
        productGallery.setThumbnail(Objects.requireNonNullElse(thumbnail, false));
        productGalleryRepository.save(productGallery);
    }

    @Override
    public void createProductGallery(Product product, List<ProductGalleryRequest> list) {
        list.forEach(img -> {
            ProductGallery productGallery = new ProductGallery();
            productGallery.setProduct(product);
            productGallery.setImagePath(img.getImagePath());
            productGallery.setThumbnail(Objects.requireNonNullElse(img.getThumbnail(), false));
            productGalleryRepository.save(productGallery);
        });
    }
}
