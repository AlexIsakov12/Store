package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {
}
