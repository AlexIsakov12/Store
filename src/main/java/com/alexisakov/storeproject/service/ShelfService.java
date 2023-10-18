package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.Shelf;
import com.alexisakov.storeproject.repository.ShelfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {
    private final ShelfRepository shelfRepository;

    public ShelfService(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    public void save(Shelf shelf) {
        shelfRepository.save(shelf);
    }

    public void saveAll(List<Shelf> shelfList) {
        shelfRepository.saveAll(shelfList);
    }
}
