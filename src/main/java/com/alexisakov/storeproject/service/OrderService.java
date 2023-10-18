package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.Order;
import com.alexisakov.storeproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

}
