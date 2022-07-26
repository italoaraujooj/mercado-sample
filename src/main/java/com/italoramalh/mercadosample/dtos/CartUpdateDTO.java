package com.italoramalh.mercadosample.dtos;

import com.italoramalh.mercadosample.models.Product;

import java.util.Map;

public class CartUpdateDTO {

    private Long id;

    private Map<Long, Product> products;

    public CartUpdateDTO(Long id, Map<Long, Product> products) {
        this.id = id;
        this.products = products;
    }
}
