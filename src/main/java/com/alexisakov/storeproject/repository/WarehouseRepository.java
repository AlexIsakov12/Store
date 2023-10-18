package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
