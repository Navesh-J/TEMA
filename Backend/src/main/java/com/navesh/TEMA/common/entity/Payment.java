package com.navesh.TEMA.common.entity;

import com.navesh.TEMA.common.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseEntity {

    @OneToOne
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    private Double amount;
    private String status;
}
