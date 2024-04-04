package com.project.product.repository;

import com.project.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product " +
            "JOIN product_category ON product.id = product_category.product_id " +
            "WHERE product_category.category_id = :categoryId", nativeQuery = true)
    List<Product> getListProductByCategoryId(@Param("categoryId") Long categoryId);
}
