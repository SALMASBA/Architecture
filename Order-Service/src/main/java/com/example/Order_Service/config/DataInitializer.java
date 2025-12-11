package com.example.Order_Service.config;

import com.example.Order_Service.model.Order;
import com.example.Order_Service.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(OrderRepository orderRepository) {
        return args -> {
            // Create test orders
            Order order1 = new Order();
            order1.setCustomerId(100L);
            order1.setStatus("PENDING");
            order1.setTotal(250.50);
            orderRepository.save(order1);

            Order order2 = new Order();
            order2.setCustomerId(101L);
            order2.setStatus("COMPLETED");
            order2.setTotal(150.75);
            orderRepository.save(order2);

            Order order3 = new Order();
            order3.setCustomerId(102L);
            order3.setStatus("SHIPPED");
            order3.setTotal(99.99);
            orderRepository.save(order3);

            System.out.println("✅ Test orders created successfully!");
        };
    }
}