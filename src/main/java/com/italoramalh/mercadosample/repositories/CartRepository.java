package com.italoramalh.mercadosample.repositories;

import com.italoramalh.mercadosample.models.Cart;
import com.italoramalh.mercadosample.models.Category;
import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c JOIN FETCH c.products WHERE c.user.id = :id")
    Optional<Cart> findCartByUserId(@Param("id") Long id);
}
