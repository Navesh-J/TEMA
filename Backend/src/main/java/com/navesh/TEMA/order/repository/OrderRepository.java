package com.navesh.TEMA.order.repository;

import com.navesh.TEMA.common.entity.Order;
import com.navesh.TEMA.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

    List<Order> findByUserOrderByCreatedAtDesc(User user);
}
