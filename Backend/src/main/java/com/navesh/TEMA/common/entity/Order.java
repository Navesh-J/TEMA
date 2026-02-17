package com.navesh.TEMA.common.entity;

import com.navesh.TEMA.common.enums.OrderStatus;
import com.navesh.TEMA.common.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {

    @ManyToOne
    private User user;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String phone;
}
