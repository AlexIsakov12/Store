package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.ShelfCategory;
import com.alexisakov.storeproject.repository.ShelfCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfCategoryService {
    private final ShelfCategoryRepository shelfCategoryRepository;

    public ShelfCategoryService(ShelfCategoryRepository shelfCategoryRepository) {
        this.shelfCategoryRepository = shelfCategoryRepository;
    }

    public void saveAll(List<ShelfCategory> shelfCategoryList) {
        shelfCategoryRepository.saveAll(shelfCategoryList);
    }
}
