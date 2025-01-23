package com.cintest.orders.service.order;

import com.cintest.orders.model.dto.CreateOrderDto;
import com.cintest.orders.vo.OrderVo;

import java.util.List;

public interface IOrderService {
    List<OrderVo> getAllOrders();
//    Order getOrderById(int orderId);
    OrderVo createOrder(CreateOrderDto dto);
}
