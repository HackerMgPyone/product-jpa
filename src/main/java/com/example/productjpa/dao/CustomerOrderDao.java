package com.example.productjpa.dao;

import com.example.productjpa.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder,Integer> {
}
