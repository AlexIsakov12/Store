package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.ShelfCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfCategoryRepository extends JpaRepository<ShelfCategory, Long> {
}
