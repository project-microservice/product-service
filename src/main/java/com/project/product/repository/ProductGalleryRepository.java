package com.project.product.repository;


import com.project.product.entity.ProductGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGalleryRepository extends JpaRepository<ProductGallery, Long> {
}
