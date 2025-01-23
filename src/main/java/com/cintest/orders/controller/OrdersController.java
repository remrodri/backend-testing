package com.cintest.orders.controller;

//import com.cintest.orders.dto.order.OrderRequest;
//import com.cintest.orders.model.Order;
import com.cintest.orders.model.Entity.Order;
import com.cintest.orders.model.dto.CreateOrderDto;
import com.cintest.orders.service.order.IOrderService;
import com.cintest.orders.service.order.OrderService;
import com.cintest.orders.vo.OrderVo;
import com.cintest.orders.vo.StandarResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
//    @Autowired
//    private IOrderService orderService;

    @GetMapping()
    public ResponseEntity<?> findAllOrders() {
        List<OrderVo>vos = orderService.getAllOrders();
        StandarResponse response = StandarResponse
                .builder()
                .message("Pedidos obtenidos correctamente")
                .data(vos)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
//        return ResponseEntity.ok(orderService.getAllOrders());

    }

//    @GetMapping("/{orderId}")
//    public ResponseEntity<Order> getProductById(@PathVariable int orderId) {
//        return ResponseEntity.ok(orderService.getOrderById(orderId));
//    }

    @PostMapping()
    public ResponseEntity<StandarResponse> createOrder(@Valid @RequestBody CreateOrderDto dto) {
//        return ResponseEntity.ok(orderService.createOrder(orderRequest));
        System.out.println(dto.toString());
        OrderVo vo = orderService.createOrder(dto);
        StandarResponse response = StandarResponse
                .builder()
                .message("Pedido creado correctamente")
                .data(vo)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
