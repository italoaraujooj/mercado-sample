package com.italoramalh.mercadosample.controllers;

import com.italoramalh.mercadosample.models.Category;
import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.models.User;
import com.italoramalh.mercadosample.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<?> create(@RequestBody Product product){
        this.productService.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @GetMapping(value = "/product")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Product>>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return new ResponseEntity<Product>(this.productService.getOne(id), HttpStatus.FOUND) ;
    }

}
