package com.pm.common.dto.response;

import com.pm.common.constant.OrderStatus;
import lombok.Data;

import java.util.List;
@Data
public class Order {
    int id;
    int total;
    OrderStatus status;
    List<OrderDetail> orderDetails;
}
