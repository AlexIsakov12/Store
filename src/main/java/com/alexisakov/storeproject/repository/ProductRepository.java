package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
