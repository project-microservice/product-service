package com.project.product.repository;

import com.project.product.entity.ProductAttribute;
import com.project.product.entity.embeddedId.ProductAttributeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, ProductAttributeId> {
}
