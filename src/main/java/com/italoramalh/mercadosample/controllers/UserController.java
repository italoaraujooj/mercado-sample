package com.italoramalh.mercadosample.controllers;

import com.italoramalh.mercadosample.models.Cart;
import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.models.User;
import com.italoramalh.mercadosample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping(value = "users")
//    public List<User> getAll(){ return this.userService.findAll();  }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return new ResponseEntity<User>(this.userService.getOne(id), HttpStatus.FOUND);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody User user){
        this.userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/{id}/cart")
    public ResponseEntity<?> getCart(@PathVariable Long id) {
        return new ResponseEntity<Cart>(this.userService.getCart(id), HttpStatus.FOUND); }

    @PutMapping(value = "/user/{id}/cart")
    public ResponseEntity<?> addToCart(@PathVariable Long id, @RequestBody Product product){
        this.userService.addProductCartById(id, product);
        return new ResponseEntity<Product>(product, HttpStatus.OK) ;
    }



//    @PatchMapping(value = "users/{id}")
//    public User update(@RequestBody User user, @PathVariable Long id){
//        return this.userService.update(id, user);
//    }

//    @DeleteMapping(value = "users/{id}")
//    public void delete(@PathVariable Long id){
//        this.userService.delete(id);
//    }


}
