package com.example.Order_Service.web.rest;


import com.example.Order_Service.model.Order;
import com.example.Order_Service.repository.OrderRepository;
import com.example.Order_Service.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderServiceImpl orderService;
    private final OrderRepository orderRepository; // <--- On a ajouté ça

    public OrderRestController(OrderServiceImpl orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    // TA MÉTHODE EXISTANTE (POST)
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // --- LA SOLUTION À TON ERREUR 405 (GET) ---
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
