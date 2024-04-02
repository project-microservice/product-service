package com.project.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attributeValue;

    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;
}
