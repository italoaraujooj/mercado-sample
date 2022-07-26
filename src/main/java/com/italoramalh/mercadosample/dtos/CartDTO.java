package com.italoramalh.mercadosample.dtos;

import com.italoramalh.mercadosample.models.Product;

import java.util.Map;

public class CartDTO {

    private String lastUpdate;

    private Map<Long, Product> products;

    public CartDTO(String lastUpdate, Map<Long, Product> products) {
        this.lastUpdate = lastUpdate;
        this.products = products;
    }
}
