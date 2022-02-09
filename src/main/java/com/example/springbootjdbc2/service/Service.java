package com.example.springbootjdbc2.service;

import com.example.springbootjdbc2.repository.Orders;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private Orders orders;

    public Service(Orders orders) {
        this.orders = orders;
    }

    public List<String> getProductFromRepo(String name){
        return orders.getProductName(name);
    }
}
