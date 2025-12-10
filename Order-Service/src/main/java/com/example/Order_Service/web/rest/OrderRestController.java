package com.example.Order_Service.web.rest;






import com.example.Order_Service.model.Order;
import com.example.Order_Service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderService service;

    public OrderRestController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/customer/{id}")
    public List<Order> getByCustomer(@PathVariable Long id) {
        return service.getOrdersByCustomer(id);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/{id}/total")
    public Double getTotal(@PathVariable Long id) {
        return service.calculateTotal(id);
    }
}
