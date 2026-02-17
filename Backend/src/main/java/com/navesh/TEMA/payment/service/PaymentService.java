package com.navesh.TEMA.payment.service;

import com.navesh.TEMA.common.entity.Order;
import com.navesh.TEMA.common.entity.Payment;
import com.navesh.TEMA.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment recordPayment(Order order) {

        Payment p = new Payment();
        p.setOrder(order);
        p.setAmount(order.getTotalAmount());
        p.setMethod(order.getPaymentMethod());
        p.setStatus("SUCCESS");

        return paymentRepository.save(p);
    }
}
