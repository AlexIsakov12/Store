package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.ShelfProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfProductRepository extends JpaRepository<ShelfProduct, Long> {
}
