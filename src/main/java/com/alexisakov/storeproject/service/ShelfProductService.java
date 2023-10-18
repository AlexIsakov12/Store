package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.ShelfProduct;
import com.alexisakov.storeproject.repository.ShelfProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfProductService {
    private final ShelfProductRepository shelfProductRepository;

    public ShelfProductService(ShelfProductRepository shelfProductRepository) {
        this.shelfProductRepository = shelfProductRepository;
    }

    public void saveAll(List<ShelfProduct> shelfProductList) {
        shelfProductRepository.saveAll(shelfProductList);
    }
}
