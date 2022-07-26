package com.italoramalh.mercadosample.dtos;

public class UserCreationDTO {

    private String username;

    private String name;

    private String email;

    public UserCreationDTO(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }
}
