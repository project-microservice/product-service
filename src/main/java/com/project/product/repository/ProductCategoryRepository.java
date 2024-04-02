package com.project.product.repository;

import com.project.product.entity.ProductCategory;
import com.project.product.entity.embeddedId.ProductCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryId> {}
