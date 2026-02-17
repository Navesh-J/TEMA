package com.navesh.TEMA.order.controller;

import com.navesh.TEMA.common.entity.Order;
import com.navesh.TEMA.common.entity.OrderStatusHistory;
import com.navesh.TEMA.common.response.ApiResponse;
import com.navesh.TEMA.order.dto.CheckoutRequest;
import com.navesh.TEMA.order.dto.UpdateOrderStatusRequest;
import com.navesh.TEMA.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/orders")
@CrossOrigin(origins = "*")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public ApiResponse<Order> checkout(Authentication auth, @RequestBody CheckoutRequest request) {

        return ApiResponse.success("Order placed successfully", orderService.checkout(auth.getName(), request));
    }

    @GetMapping
    public ApiResponse<List<Order>> getOrders(Authentication auth) {

        return ApiResponse.success("Orders fetched", orderService.getUserOrders(auth.getName()));
    }

    @GetMapping("/vendor")
    public ApiResponse<List<Order>> getVendorOrders(Authentication auth) {

        return ApiResponse.success("Vendor orders fetched", orderService.getVendorOrders(auth.getName()));
    }

    @PutMapping("/vendor/{orderId}/status")
    public ApiResponse<Order> updateStatus(Authentication auth, @PathVariable Long orderId, @RequestBody UpdateOrderStatusRequest request) {

        return ApiResponse.success("Order status updated", orderService.updateOrderStatus(orderId, auth.getName(), request));
    }

    @GetMapping("/{orderId}/status")
    public ApiResponse<List<OrderStatusHistory>> getStatusHistory(@PathVariable Long orderId) {

        return ApiResponse.success("Order status history fetched", orderService.getOrderStatusHistory(orderId));
    }

}
