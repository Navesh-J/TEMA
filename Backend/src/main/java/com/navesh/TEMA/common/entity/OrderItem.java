package com.navesh.TEMA.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity {

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User vendor;

    private int quantity;
    private Double price;
}
