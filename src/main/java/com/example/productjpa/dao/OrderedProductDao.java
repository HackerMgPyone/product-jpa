package com.example.productjpa.dao;

import com.example.productjpa.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductDao extends JpaRepository<OrderedProduct,Integer> {
}
