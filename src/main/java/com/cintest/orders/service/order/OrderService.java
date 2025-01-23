package com.cintest.orders.service.order;

import com.cintest.orders.model.Entity.Order;
import com.cintest.orders.model.Entity.Product;
import com.cintest.orders.model.Exception.ProductNotFoundException;
import com.cintest.orders.model.dto.CreateOrderDto;
import com.cintest.orders.repository.IOrderRepository;
import com.cintest.orders.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;
    private final IProductService productService;

    public OrderService(IOrderRepository orderRepository,ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public List<OrderVo> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order->new OrderVo(
                order.getId(),
                order.getOUnits(),
                order.getOBonus(),
                order.getOPromo(),
                order.getOTotalPrice(),
                order.getProduct().getId()
        )).toList();
    }

    @Override
    public OrderVo createOrder(CreateOrderDto dto) {
        Optional<Product> product = productService.findProductById(dto.productId());
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        Order order = new Order();
        order.setOUnits(dto.units());
        order.setOBonus(dto.bonus());
        order.setOPromo(dto.promo());
        order.setOTotalPrice(dto.totalPrice());
        order.setProduct(product.get());

        Order savedOrder = orderRepository.save(order);

        return new OrderVo(
                savedOrder.getId(),
                savedOrder.getOUnits(),
                savedOrder.getOBonus(),
                savedOrder.getOPromo(),
                savedOrder.getOTotalPrice(),
                savedOrder.getProduct().getId()
        );
    }

//    @Autowired
//    private OrderRepository orderRepository;
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//    public Order getOrderById(int orderId) {
//        return orderRepository.findById(orderId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "order not found"));
//    }
//
//    public Order createOrder(OrderRequest orderRequest) {
//        Order order = orderRequest.toEntity();
//        return orderRepository.save(order);
//    }
}
