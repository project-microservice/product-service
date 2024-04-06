package com.project.product.entity;

import jakarta.persistence.*;
import lombok.*;

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
//    private Integer stockQuantity;
    private Double productWeight;
}
