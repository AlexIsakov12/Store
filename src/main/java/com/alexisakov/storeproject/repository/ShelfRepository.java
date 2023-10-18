package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf,Long> {
}
