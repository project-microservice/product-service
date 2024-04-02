package com.project.product.entity;

import com.project.product.entity.embeddedId.ProductAttributeId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttribute {
    @EmbeddedId
    private ProductAttributeId productAttributeId;
}
