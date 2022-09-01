package com.italoramalh.mercadosample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler({CartNotFoundException.class})
    public ResponseEntity<?> CartNotFoundException(CartNotFoundException e, HttpServletRequest request){
        StandartError erroStandart = new StandartError();
        erroStandart.setMessage(e.getMessage());
        erroStandart.setTimeStamp(new Date().getTime());
        erroStandart.setError("cart01");
        return new ResponseEntity<StandartError>(erroStandart, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<?> ProductNotFoundException(ProductNotFoundException e, HttpServletRequest request){
        StandartError erroStandart = new StandartError();
        erroStandart.setMessage(e.getMessage());
        erroStandart.setTimeStamp(new Date().getTime());
        erroStandart.setError("prod01");
        return new ResponseEntity<StandartError>(erroStandart, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> UserNotFoundException(UserNotFoundException e, HttpServletRequest request){
        StandartError erroStandart = new StandartError();
        erroStandart.setMessage(e.getMessage());
        erroStandart.setTimeStamp(new Date().getTime());
        erroStandart.setError("user01");
        return new ResponseEntity<StandartError>(erroStandart, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CategoryNotFoundException.class})
    public ResponseEntity<?> CategoryNotFoundException(CategoryNotFoundException e, HttpServletRequest request){
        StandartError erroStandart = new StandartError();
        erroStandart.setMessage(e.getMessage());
        erroStandart.setTimeStamp(new Date().getTime());
        erroStandart.setError("cat01");
        return new ResponseEntity<StandartError>(erroStandart, HttpStatus.NOT_FOUND);
    }
}
