package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.OrderItem;
import com.alexisakov.storeproject.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void saveAll(List<OrderItem> orderItemList) {
        orderItemRepository.saveAll(orderItemList);
    }
}
