package com.example.Order_Service.dto;



import com.example.Order_Service.model.OrderItem;
import java.util.List;

public class CreateOrderRequest {
    private Long clientId;
    private List<OrderItem> items;
    // getters/setters
}

