package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.Product;
import com.alexisakov.storeproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveAll(List<Product> productList) {
        productRepository.saveAll(productList);
    }
}
