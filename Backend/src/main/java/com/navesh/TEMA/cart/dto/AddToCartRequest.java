package com.navesh.TEMA.cart.dto;

import lombok.Data;

@Data
public class AddToCartRequest {

    private Long productId;
    private int quantity;
}
