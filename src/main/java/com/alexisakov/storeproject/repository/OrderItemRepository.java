package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
