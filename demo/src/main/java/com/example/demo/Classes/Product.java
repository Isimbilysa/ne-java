package com.example.demo.Classes;


import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @Getter
    private String name;
    @Getter
    private String productType;
    @Getter
    private double price;
    @Getter
    private LocalDate inDate;
    @Getter
    private String image;
    @Getter
    private int id;

    public void setId(int id){
        this.id=id;
    }

    public void setCode(Long id){
        this.code=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(){
        this.productType= productType;
    }

    public void setPrice(){
    }

    public void setInDate(){
    }
    public void setImage(){
        this.image=image;
    }
}
