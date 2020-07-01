package com.amdocs.badillo.customers.controllers;

import com.amdocs.badillo.customers.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @GetMapping("/products")
    public List<Product> all(){
        List<Product> allProducts = new ArrayList<>();

        allProducts.add( new Product(0, "Optic Fiber 300"));
        allProducts.add( new Product(1, "Product 1"));
        allProducts.add( new Product(2, "Product 2"));

        return allProducts;
    }
}
