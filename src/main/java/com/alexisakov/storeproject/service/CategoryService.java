package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.ProductCategory;
import com.alexisakov.storeproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveAll(List<ProductCategory> productCategoryList) {
        categoryRepository.saveAll(productCategoryList);
    }
}
