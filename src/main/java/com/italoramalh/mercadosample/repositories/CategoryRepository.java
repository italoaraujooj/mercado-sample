package com.italoramalh.mercadosample.repositories;

import com.italoramalh.mercadosample.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
