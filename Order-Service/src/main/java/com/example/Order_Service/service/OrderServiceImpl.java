package com.example.Order_Service.service;




import com.example.Order_Service.model.Order;
import com.example.Order_Service.repository.OrderItemRepository;
import com.example.Order_Service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository itemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Order createOrder(Order order) {
        double total = order.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();

        order.setTotal(total);

        order.getItems().forEach(i -> i.setOrder(order));

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order updateStatus(Long id, String status) {
        Order o = orderRepository.findById(id).orElse(null);
        if (o == null) return null;
        o.setStatus(status);
        return orderRepository.save(o);
    }

    @Override
    public Double calculateTotal(Long id) {
        Order o = orderRepository.findById(id).orElse(null);
        if (o == null) return null;
        return o.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
