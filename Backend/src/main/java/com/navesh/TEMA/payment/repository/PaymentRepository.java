package com.navesh.TEMA.payment.repository;

import com.navesh.TEMA.common.entity.Order;
import com.navesh.TEMA.common.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByOrder(Order order);
}
