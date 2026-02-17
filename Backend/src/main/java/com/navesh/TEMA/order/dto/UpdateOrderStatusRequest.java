package com.navesh.TEMA.order.dto;

import com.navesh.TEMA.common.enums.OrderStatus;
import lombok.Data;

@Data
public class UpdateOrderStatusRequest {

    private OrderStatus status;
}
