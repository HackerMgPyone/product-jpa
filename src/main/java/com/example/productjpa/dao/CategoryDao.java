package com.example.productjpa.dao;

import com.example.productjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
