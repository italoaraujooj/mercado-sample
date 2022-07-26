package com.italoramalh.mercadosample.dtos;

public class ProductDTO {

    private Long id;

    private String name;

    private double price;

    private String description;

    private boolean available;

    private String imageUrl;

    private String categoryId;

    public ProductDTO(Long id, String name, double price, String description, boolean available, String imageUrl, String categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }
}
