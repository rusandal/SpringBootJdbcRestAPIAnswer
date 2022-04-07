package com.example.springbootjdbc2.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private int id;
    private String name;
    private Date date;
    private String productName;
    private int amount;
    private int customer_id;
}
