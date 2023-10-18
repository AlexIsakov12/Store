package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.Warehouse;
import com.alexisakov.storeproject.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }
}
