package com.italoramalh.mercadosample.services;

import com.italoramalh.mercadosample.exceptions.CartNotFoundException;
import com.italoramalh.mercadosample.exceptions.ProductNotFoundException;
import com.italoramalh.mercadosample.exceptions.UserNotFoundException;
import com.italoramalh.mercadosample.models.Cart;
import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.models.User;
import com.italoramalh.mercadosample.repositories.ProductRepository;
import com.italoramalh.mercadosample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private CartService cartService;

    public List<User> findAll(){
        return this.userRep.findAll();
    }

    public User getOne(Long id){
        return userRep.findById(id).orElse( new User());
    }

    public User save(User user){
        return this.userRep.save(user);
    }

    public User update(Long id, User user){
        Optional<User> u = this.userRep.findById(id);

        User update = null;

        if(u.isPresent()){
            update = u.get();

            update.setName(user.getName());
            update.setUsername(user.getUsername());
            update.setEmail(user.getEmail());
            update.setPhone(user.getPhone());
            update.setPhotoUrl(user.getPhotoUrl());
        }

        return update;
    }

    public void delete(Long id){
        this.userRep.deleteById(id);
    }

    public Cart getCart(Long id) throws CartNotFoundException {
        return cartService.getCart(id);
    }


    public void addProductCartById(Long id, Product product) throws UserNotFoundException {
        cartService.addProductByUserId(id, product);
    }

    public void delProductCartById(Long id, Product product) throws UserNotFoundException, ProductNotFoundException{
        cartService.delProductCartById(id, product);
    }
}
