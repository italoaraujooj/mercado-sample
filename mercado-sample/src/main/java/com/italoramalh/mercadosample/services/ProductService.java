package com.italoramalh.mercadosample.services;

import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRep;

    public List<Product> findAll(){
        return this.productRep.findAll();
    }

    public Product getOne(Long id){
        return productRep.findById(id).orElse( new Product());
    }

    public Product save(Product product){
        return this.productRep.save(product);
    }

    public Product update(Long id, Product product){
        Optional<Product> u = this.productRep.findById(id);

        Product update = null;

        if(u.isPresent()){
            update = u.get();

            update.setName(product.getName());
            update.setDescription(product.getDescription());
            update.setAvailable(product.isAvailable());
            update.setPrice(product.getPrice());
            update.setCategoryId(product.getCategoryId());
            update.setImageUrl(product.getImageUrl());
        }

        return update;
    }

    public void delete(Long id){
        this.productRep.deleteById(id);
    }
}
