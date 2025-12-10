package com.example.Order_Service.service;







import com.example.Order_Service.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrdersByCustomer(Long customerId);
    Order updateStatus(Long id, String status);
    Double calculateTotal(Long id);
}
