package com.italoramalh.mercadosample.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private double price;

    private boolean available;

    private String imageUrl;

    private Long categoryId;

    public Product(){}

    public Product(String name, String description, double price, boolean available, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.categoryId = categoryId;
    }

    public Product(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

}
