package com.project.product.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String categoryName;
    private String categoryDescription;
    private String icon;
}
