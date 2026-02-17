package com.navesh.TEMA.product.dto;

import com.navesh.TEMA.common.enums.Category;
import lombok.Data;

@Data
public class AddProductRequest {

    private String name;
    private Double price;
    private String imageUrl;
    private Category category;
}
