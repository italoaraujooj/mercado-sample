package com.italoramalh.mercadosample.dtos;

public class UserDTO {

    private Long id;

    private String username;

    private String name;

    private String email;

    private String phone;

    private String photoUrl;

    public UserDTO(Long id, String username, String name, String email, String phone, String photoUrl) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photoUrl = photoUrl;
    }
}
