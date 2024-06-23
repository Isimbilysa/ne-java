package com.example.demo.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

@Entity
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    private String productCode;
    @Getter
    private int quantity;
    @Getter
    private double total;
    @Getter
    private LocalDate date;

    public void setId(int id) {
        this.id = id;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}