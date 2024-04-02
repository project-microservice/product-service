package com.project.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @Column(unique = true)
    private String productName;
    private Double regularPrice;
    private Integer stockQuantity;
    private Double productWeight;
    @JsonIgnore
    @OneToMany(
            mappedBy = "productAttributeId.productId",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    private Set<ProductAttribute> listAttributes;
}
