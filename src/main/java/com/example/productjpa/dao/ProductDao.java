package com.example.productjpa.dao;

import com.example.productjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
