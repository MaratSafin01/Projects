package com.example.customerdemorestapi.repo;

import com.example.customerdemorestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
