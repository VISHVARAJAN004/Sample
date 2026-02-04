package com.example.Sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name="products")

public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Schema(accessMode = Schema.AccessMode.READ_ONLY)


     private Integer id;
     private String name;
     private double price;

     public Product(){
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
