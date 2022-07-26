package com.italoramalh.mercadosample.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Map<Long, Product> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product){
        this.products.put(product.getId(), product);
    }

    public void delProduct(Product product){
        this.products.remove(product.getId());
    }

}
