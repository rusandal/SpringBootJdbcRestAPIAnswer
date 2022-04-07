package com.example.springbootjdbc2.model;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String phone;
}
