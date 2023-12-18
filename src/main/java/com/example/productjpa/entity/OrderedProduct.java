package com.example.productjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    public OrderedProduct(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private CustomerOrder customerOrder;

    @ManyToOne
    private Product product;
}
