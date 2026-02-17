package com.navesh.TEMA.common.entity;

import com.navesh.TEMA.common.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderStatusHistory extends BaseEntity {

    @ManyToOne
    private Order order;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    private User updatedBy;
}
