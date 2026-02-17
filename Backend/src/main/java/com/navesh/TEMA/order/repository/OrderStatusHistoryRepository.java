package com.navesh.TEMA.order.repository;

import com.navesh.TEMA.common.entity.Order;
import com.navesh.TEMA.common.entity.OrderStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusHistoryRepository
        extends JpaRepository<OrderStatusHistory, Long> {

    List<OrderStatusHistory> findByOrder(Order order);
}
