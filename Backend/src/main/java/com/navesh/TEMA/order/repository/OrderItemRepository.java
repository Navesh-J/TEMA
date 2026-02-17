package com.navesh.TEMA.order.repository;

import com.navesh.TEMA.common.entity.Order;
import com.navesh.TEMA.common.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(Order order);
}
