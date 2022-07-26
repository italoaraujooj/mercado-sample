package com.italoramalh.mercadosample.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String name;

    private String email;

    private String phone;

    private String photoUrl;

    @OneToOne
    private Cart cart;

    public User(){}

    public User(String username, String name, String email, String phone) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String name, String email, String phone, String photoUrl) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photoUrl = photoUrl;
    }

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public void addProductCart(Product product){
        this.cart.addProduct(product);
    }

    public void delProductCart(Product product){
        this.cart.delProduct(product);
    }

}
