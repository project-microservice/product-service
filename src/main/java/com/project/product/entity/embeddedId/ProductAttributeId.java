package com.project.product.entity.embeddedId;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProductAttributeId implements Serializable {
    private Long productId;
    private Long attributeId;
}
