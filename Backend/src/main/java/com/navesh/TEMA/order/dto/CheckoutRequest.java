package com.navesh.TEMA.order.dto;

import com.navesh.TEMA.common.enums.PaymentMethod;
import lombok.Data;

@Data
public class CheckoutRequest {

    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String phone;

    private PaymentMethod paymentMethod;
}
