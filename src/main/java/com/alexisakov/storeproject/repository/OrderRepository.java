package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
