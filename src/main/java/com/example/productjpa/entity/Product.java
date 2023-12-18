package com.example.productjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate lastUpdate;

    public Product(String name, double price, String description, LocalDate lastUpdate) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    @ManyToOne
    private Category category;



    @OneToMany(mappedBy = "product",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<OrderedProduct> orderedProducts =
            new ArrayList<>();

    public void addOrderedProduct(OrderedProduct orderedProduct){
        orderedProduct.setProduct(this);
        orderedProducts.add(orderedProduct);
    }

}
