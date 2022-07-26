package com.italoramalh.mercadosample.services;

import com.italoramalh.mercadosample.models.Category;
import com.italoramalh.mercadosample.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRep;

    public List<Category> findAll(){
        return this.categoryRep.findAll();
    }

    public Category getOne(Long id){
        return categoryRep.findById(id).orElse( new Category());
    }

    public Category save(Category Category){
        return this.categoryRep.save(Category);
    }

    public Category update(Long id, Category Category){
        Optional<Category> u = this.categoryRep.findById(id);

        Category update = null;

        if(u.isPresent()){
            update = u.get();

            update.setName(Category.getName());
            update.setDescription(Category.getDescription());
        }

        return update;
    }

    public void delete(Long id){
        this.categoryRep.deleteById(id);
    }
}
