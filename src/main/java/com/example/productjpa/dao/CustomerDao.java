package com.example.productjpa.dao;

import com.example.productjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
