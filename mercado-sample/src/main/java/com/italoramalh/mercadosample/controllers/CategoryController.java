package com.italoramalh.mercadosample.controllers;

import com.italoramalh.mercadosample.models.Category;
import com.italoramalh.mercadosample.models.User;
import com.italoramalh.mercadosample.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Category>>(this.categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<?> create(@RequestBody Category category){
        this.categoryService.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.CREATED);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return new ResponseEntity<Category>(this.categoryService.getOne(id), HttpStatus.OK);
    }
}
