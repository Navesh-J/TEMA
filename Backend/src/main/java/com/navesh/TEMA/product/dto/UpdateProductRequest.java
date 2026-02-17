package com.navesh.TEMA.product.dto;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private String name;
    private Double price;
    private String imageUrl;
    private Boolean active;
}
