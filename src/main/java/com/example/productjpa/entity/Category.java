package com.example.productjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Product> products =
            new ArrayList<>();

    public void addProduct(Product product){
        product.setCategory(this);
        products.add(product);

    }


}
