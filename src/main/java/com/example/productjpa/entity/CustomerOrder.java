package com.example.productjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private LocalDate dateCreated;
    private int confirmationNum;

    public CustomerOrder(double amount, LocalDate dateCreated, int confirmationNum) {
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.confirmationNum = confirmationNum;
    }

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<OrderedProduct> orderedProducts =
            new ArrayList<>();

    public void addOrderedProduct(OrderedProduct orderedProduct){
        orderedProduct.setCustomerOrder(this);
        orderedProducts.add(orderedProduct);
    }
}
