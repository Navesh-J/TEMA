package com.navesh.TEMA.order.service;

import com.navesh.TEMA.cart.repository.*;
import com.navesh.TEMA.common.entity.*;
import com.navesh.TEMA.common.enums.OrderStatus;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.order.dto.CheckoutRequest;
import com.navesh.TEMA.order.dto.UpdateOrderStatusRequest;
import com.navesh.TEMA.order.repository.*;
import com.navesh.TEMA.payment.service.PaymentService;
import com.navesh.TEMA.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderStatusHistoryRepository statusHistoryRepository;


    public Order checkout(String email, CheckoutRequest request) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        List<CartItem> items = cartItemRepository.findByCart(cart);

        double total = items.stream()
                .mapToDouble(i -> i.getPriceAtTime() * i.getQuantity())
                .sum();

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setPaymentMethod(request.getPaymentMethod());
        order.setStatus(OrderStatus.RECEIVED);

        order.setName(request.getName());
        order.setEmail(request.getEmail());
        order.setAddress(request.getAddress());
        order.setCity(request.getCity());
        order.setState(request.getState());
        order.setPinCode(request.getPinCode());
        order.setPhone(request.getPhone());

        order = orderRepository.save(order);

        for (CartItem item : items) {

            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(item.getProduct());
            oi.setVendor(item.getProduct()
                    .getVendor());
            oi.setQuantity(item.getQuantity());
            oi.setPrice(item.getPriceAtTime());

            orderItemRepository.save(oi);
        }

        paymentService.recordPayment(order);

        cartItemRepository.deleteByCart(cart);

        return order;
    }

    public List<Order> getUserOrders(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return orderRepository.findByUser(user);
    }

    public List<Order> getVendorOrders(String vendorEmail) {

        User vendor = userRepository.findByEmail(vendorEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        return orderRepository.findAll()
                .stream()
                .filter(order -> orderItemRepository.findByOrder(order)
                        .stream()
                        .anyMatch(item -> item.getVendor()
                                .getId()
                                .equals(vendor.getId())))
                .toList();
    }

    public Order updateOrderStatus(Long orderId, String vendorEmail, UpdateOrderStatusRequest request) {

        User vendor = userRepository.findByEmail(vendorEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus(request.getStatus());
        orderRepository.save(order);

        OrderStatusHistory history = new OrderStatusHistory();
        history.setOrder(order);
        history.setStatus(request.getStatus());
        history.setUpdatedBy(vendor);

        statusHistoryRepository.save(history);

        return order;
    }

    public List<OrderStatusHistory> getOrderStatusHistory(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        return statusHistoryRepository.findByOrder(order);
    }


}
