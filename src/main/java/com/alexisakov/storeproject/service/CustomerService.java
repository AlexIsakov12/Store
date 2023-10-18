package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.Customer;
import com.alexisakov.storeproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

}
