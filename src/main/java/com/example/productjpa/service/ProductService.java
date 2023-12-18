package com.example.productjpa.service;

import com.example.productjpa.dao.*;
import com.example.productjpa.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryDao categoryDao;
    private final CustomerDao customerDao;
    private final CustomerOrderDao customerOrderDao;
    private final OrderedProductDao orderedProductDao;
    private final ProductDao productDao;

    @Transactional
    public void createDb(){

        Category category1 = new Category();
        category1.setName("Foods");

        Category category2 = new Category();
        category2.setName("Drinks");

        Product product1 = new Product("potato chips",700,
                "this potato chips is very good.", LocalDate.of(2023,02,13));

        Product product2 = new Product("cake",1500,
                "this cake is very good.",LocalDate.of(2023,02,13));

        Product product3 = new Product("coke",700,
                "this coke is very good.",LocalDate.of(2023,02,13));

        Product product4 = new Product("pepsi",700,
                "this pepsi is very good.",LocalDate.of(2023,02,13));

        Product product5 = new Product("ice-cream",700,
                "this ice-cream is very good.",LocalDate.of(2023,02,13));

        Product product6 = new Product("shark",1600,
                "this energy drink is very good.",LocalDate.of(2023,02,13));

        Customer customer1 = new Customer("Mg Mg","mgmg@gmail.com","000-000-000","Hlaing","Yangon","007");
        Customer customer2 = new Customer("Su Su","susu@gmail.com","555-555-555","Kamaryut","Yangon","003");


        CustomerOrder customerOrder1 = new CustomerOrder(10,LocalDate.of(2023,02,13),001);
        CustomerOrder customerOrder2 = new CustomerOrder(30,LocalDate.of(2023,02,13),002);

        OrderedProduct orderedProduct1 = new OrderedProduct(20);
        OrderedProduct orderedProduct2 = new OrderedProduct(30);


        //mapping

        category1.addProduct(product1);
        category1.addProduct(product2);
        category1.addProduct(product5);

        category2.addProduct(product3);
        category2.addProduct(product4);
        category2.addProduct(product6);


        customer1.addCustomerOrder(customerOrder1);
        customer1.addCustomerOrder(customerOrder2);


        customer2.addCustomerOrder(customerOrder2);
        customer2.addCustomerOrder(customerOrder1);

        customerOrder1.addOrderedProduct(orderedProduct1);
        customerOrder1.addOrderedProduct(orderedProduct2);

        customerOrder2.addOrderedProduct(orderedProduct1);
        customerOrder2.addOrderedProduct(orderedProduct2);

        product1.addOrderedProduct(orderedProduct1);
        product1.addOrderedProduct(orderedProduct2);

        product2.addOrderedProduct(orderedProduct1);
        product2.addOrderedProduct(orderedProduct2);

        product3.addOrderedProduct(orderedProduct1);
        product3.addOrderedProduct(orderedProduct2);

        product4.addOrderedProduct(orderedProduct1);
        product4.addOrderedProduct(orderedProduct2);

        product5.addOrderedProduct(orderedProduct1);
        product5.addOrderedProduct(orderedProduct2);

        product6.addOrderedProduct(orderedProduct1);
        product6.addOrderedProduct(orderedProduct2);

        orderedProductDao.save(orderedProduct1);
        orderedProductDao.save(orderedProduct2);

        customerOrderDao.save(customerOrder1);
        customerOrderDao.save(customerOrder2);


        categoryDao.save(category1);
        categoryDao.save(category2);

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        productDao.save(product4);
        productDao.save(product5);
        productDao.save(product6);

        customerDao.save(customer1);
        customerDao.save(customer2);


    }
}
