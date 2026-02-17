package com.navesh.TEMA.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem extends BaseEntity {

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int quantity;
    private Double priceAtTime;
}
