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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String cityRegion;
    private String ccNum;

    public Customer(String name, String email, String phone, String address, String cityRegion, String ccNum) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cityRegion = cityRegion;
        this.ccNum = ccNum;
    }

    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<CustomerOrder> customerOrders =
            new ArrayList<>();

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrder.setCustomer(this);
        customerOrders.add(customerOrder);
    }

}
