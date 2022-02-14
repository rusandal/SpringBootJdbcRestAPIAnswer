package com.example.springbootjdbc2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class OrdersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private String productName;
    private Integer amount;
    @ManyToOne
    private Customers customers;
}
