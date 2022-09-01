package com.italoramalh.mercadosample.exceptions;

public class CategoryNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
