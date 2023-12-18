package com.example.productjpa;

import com.example.productjpa.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ProductJpaApplication implements CommandLineRunner {

    private final ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ProductJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
          productService.createDb();

        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from ordered_product");

    }
}
