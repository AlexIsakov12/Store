package com.alexisakov.storeproject.repository;

import com.alexisakov.storeproject.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
