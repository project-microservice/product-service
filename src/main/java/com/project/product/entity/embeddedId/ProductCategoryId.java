package com.project.product.entity.embeddedId;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class ProductCategoryId implements Serializable {
    private Long productId;
    private Long categoryId;

    public ProductCategoryId(Long productId, Long categoryId){
        this.productId = productId;
        this.categoryId = categoryId;
    }
}
