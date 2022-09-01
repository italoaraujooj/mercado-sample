package com.italoramalh.mercadosample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Cart")
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Set<Product> products = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void delProduct(Product product){
        this.products.remove(product.getId());
    }

}
