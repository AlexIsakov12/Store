package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
